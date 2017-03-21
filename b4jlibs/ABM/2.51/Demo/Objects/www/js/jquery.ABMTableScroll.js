/*!
 * ABMTableScroll by Alain Bailleul inspired by jTableScroll by
 * http://mikeallisononline.com/
 *
 * Dependent on jquery
 * http://jquery.com/
 *
 * Copyright 2013 Mike Allison
 * Released under the MIT license
 * http://opensource.org/licenses/MIT 
 */

(function ($) {
    $.fn.ABMTableScroll = function () {
        
        //get scrollbar size             
        var dummy = $('<div>').css({ visibility: 'hidden', width: '50px', height:'50px', overflow: 'scroll' }).appendTo('body');
        var scrollbarpx = 50 - $('<div>').height(99).appendTo(dummy).outerWidth();
        dummy.remove();

        //IE8 browser test (because it's bad)
        var rv = -1;
        var ua = navigator.userAgent;
        var re = new RegExp("Trident\/([0-9]{1,}[\.0-9]{0,})");
        if (re.exec(ua) != null) {
            rv = parseFloat(RegExp.$1);
        }
        var ie8 = (rv == 4);

        this.each(function () {
			
            var self = $(this);
            var parent = self.parent();
			
			var parentHeight = parent.height();  
			var parentWidth = parent.width();  
			var headerHeight = self.find('thead').height();
			var bodyHeight = self.find('tbody').height();
			var footerHeight = self.find('tfoot').height();
			//var bodyWidth = self.find('tbody').width();
									
			 //Create header clone
            var cloneTable = self.clone();
            cloneTable.find('tbody').remove();
            cloneTable.find('tfoot').remove();
			
            //Create footer clone
            var cloneFoot = self.clone();
            cloneFoot.find('tbody').remove();
            cloneFoot.find('thead').remove();
			
			 var headBgColor = null;
            //Set header/footer column widths and click events
			var bodyWidth=0;
            self.find('thead').find('th').each(function(index, value) {
                var val = $(value);
                var tdwidth = val.width();
				headBgColor = val.bkgcolor();
                //totalWidth+=tdwidth;
                val.css("width", tdwidth + 'px'); //reinforce width
                $(cloneTable.find('th')[index]).click(function() { val.click(); });
                $(cloneTable.find('th')[index]).width(tdwidth);
                $(cloneFoot.find('th')[index]).click(function () { val.click(); });
                $(cloneFoot.find('td')[index]).width(tdwidth);
				bodyWidth+=tdwidth;
            });
		
			//Create header div
            var headerdiv = $(document.createElement('div'));
		
			 //Create footer div
            var footerdiv = $(document.createElement('div'));
		
			 //Create outer div
            var outerdiv = $(document.createElement('div'));
			if (bodyWidth<parentWidth) {
				outerdiv.css({ 'overflow': 'hidden' }).width(bodyWidth).height(parentHeight);
				headerdiv.css({ 'overflow': 'hidden', 'position': 'relative', 'background-color': headBgColor, 'z-index': '2' }).width(bodyWidth);
				footerdiv.css({ 'overflow': 'hidden', 'position': 'relative', 'background-color': headBgColor, 'z-index': '2' }).width(bodyWidth);
			} else {
				outerdiv.css({ 'overflow': 'hidden' }).width(parentWidth-scrollbarpx).height(parentHeight);
				headerdiv.css({ 'overflow': 'hidden', 'position': 'relative', 'background-color': headBgColor, 'z-index': '2' }).width(parentWidth-scrollbarpx);
				footerdiv.css({ 'overflow': 'hidden', 'position': 'relative', 'background-color': headBgColor, 'z-index': '2' }).width(parentWidth-scrollbarpx);
			}  
			outerdiv.attr('id', $(this).attr('id')+"_toplevel");
			if (self.hasClass("z-depth-1")) {
				outerdiv.addClass("z-depth-1");
				self.removeClass("z-depth-1");
			}
			if (self.hasClass("z-depth-2")) {
				outerdiv.addClass("z-depth-2");
				self.removeClass("z-depth-2");
			}
			if (self.hasClass("z-depth-3")) {
				outerdiv.addClass("z-depth-3");
				self.removeClass("z-depth-3");
			}
			if (self.hasClass("z-depth-4")) {
				outerdiv.addClass("z-depth-4");
				self.removeClass("z-depth-4");
			}
			if (self.hasClass("z-depth-5")) {
				outerdiv.addClass("z-depth-5");
				self.removeClass("z-depth-5");
			}
			if (self.hasClass("z-depth-0")) {
				outerdiv.addClass("z-depth-0");
				self.removeClass("z-depth-0");
			}
			

            cloneTable.css({ 'table-layout': 'fixed', 'background-color': headBgColor }).width(bodyWidth);
			cloneFoot.css({ 'table-layout': 'fixed', 'background-color': headBgColor }).width(bodyWidth);
            self.css({ 'table-layout': 'fixed' });

            //Create body div
            var bodydiv = $(document.createElement('div'));

            //Add horizontal scroll event
            bodydiv.scroll(function () {
                headerdiv.scrollLeft(bodydiv.scrollLeft());
                footerdiv.scrollLeft(bodydiv.scrollLeft());
            });
			
			bodydiv.attr('id', $(this).attr('id')+"_innerbody");

            //Add to DOM
            headerdiv.append(cloneTable);
            footerdiv.append(cloneFoot);
            self.before(outerdiv);
            self.appendTo(bodydiv);
            outerdiv.append(headerdiv);
            outerdiv.append(bodydiv);
            outerdiv.append(footerdiv);
			
			var combinedHeight = bodyHeight + headerHeight + footerHeight;
			var extra=0;
            if (combinedHeight >= parentHeight) {
				extra=scrollbarpx;				
            } else {
				self.find('tfoot').addClass("hide");
			}
			
			outerdiv.width(outerdiv.width() + extra);
			var origMarginTop = parseFloat(bodydiv.css("margin-top"));
			marginTop = origMarginTop-headerHeight;
			var origMarginBottom = parseFloat(bodydiv.css("margin-bottom"));
            marginBottom = origMarginBottom-footerHeight;
			var extrabottom=0;
			if (bodyWidth>parentWidth) {
				extrabottom=scrollbarpx;			
			}			
			headerdiv.width(outerdiv.width()-extra);
            bodydiv.css({ 'overflow': 'auto','margin-top': marginTop + 'px', 'margin-bottom': (marginBottom - extrabottom) + 'px'}).width(outerdiv.width()).height(parentHeight);
			footerdiv.width(outerdiv.width()-extra);
			
            if (ie8)
                self.find('thead').hide();

           
           $(window).resize(function () {	
				var parentWidth = parent.width();  
				
                //var combinedHeight = self.height() + headerdiv.height() + footerdiv.height();
				var extra=0;
				if (combinedHeight >= parentHeight) {
					extra=scrollbarpx;
				}
				//console.log(bodyWidth);
				if (bodyWidth<parentWidth) {
					outerdiv.css({ 'overflow': 'hidden' }).width(bodyWidth).height(parentHeight);
				} else {
					//console.log("bigger");
					outerdiv.css({ 'overflow': 'hidden' }).width(parentWidth-scrollbarpx).height(parentHeight);
				}
			
				outerdiv.width(outerdiv.width() + extra);
				
				marginTop = origMarginTop-headerHeight;
				marginBottom = origMarginBottom-footerHeight;
				var extrabottom=0;
				if (bodyWidth>parentWidth) {
					extrabottom=scrollbarpx;
				}
				headerdiv.width(outerdiv.width()-extra);
				bodydiv.css({ 'overflow': 'auto','margin-top': marginTop + 'px', 'margin-bottom': (marginBottom - extrabottom) + 'px'}).width(outerdiv.width()).height(parentHeight);
				footerdiv.width(outerdiv.width()-extra);
            });
           

        });
    };
})(jQuery);


(function($) {
    // Get this browser's take on no fill
    // Must be appended else Chrome etc return 'initial'
    var $temp = $('<div style="background:none;display:none;"/>').appendTo('body');
    var transparent = $temp.css('backgroundColor');
    $temp.remove();

    jQuery.fn.bkgcolor = function( fallback ) {
        function test( $elem ) {
            if ( $elem.css('backgroundColor') == transparent ) {
                return !$elem.is('body') ? test( $elem.parent() ) : fallback || transparent ;
            } else {
                return $elem.css('backgroundColor');
            }
        }
        return test( $(this) );
    };

})(jQuery);