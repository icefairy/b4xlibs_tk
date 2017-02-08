// This WebApp/WebSite was generated using ABMaterial, a B4X library written by Alain Bailleul 2015-2016. See http://alwaysbusycorner.com/abmaterial/
$(window).resize(function() {$('.extrasidebar').sideNav('hide');if ($('.nav-wrapper').length>0) {var parWidth = $('.nav-wrapper').width();var myLeft = $('#pagenavbar').position().left;var myRight = 0;if ($('.nav-wrapper ul.right:last-child').length>0) {myRight = parWidth - $('.nav-wrapper ul.right:last-child').position().left;}$('#pagenavbar').outerWidth(parWidth-myLeft-myRight);}});function extrabar(id) {$('.extrasidebar:not("#' + id + '")').abmsideNav('hide');};function initplugins(){$('.materialboxed').materialbox();$('.tooltipped').tooltip({delay:50});$('.collapsible').collapsible();InitEditEnterFields();$('#sidenavbutton').on('click', function() {$('.dropdown-content').hide();});}function reinitmaterialbox(id) {$('#' + id).materialbox();}
function reinitcollapsable(id) {initcollapse(id);}
function reinitdropdown(id) {$(".dropdown-button").dropdown();}
function reinitinputfields() {InitEditEnterFields();TextAreaAllResize();$('.dropdown-button2').dropdown2();}
function inittooltipped(id){$('#' + id).tooltip({delay:50});};function replacemewith(id,html) {$('#' + id).replaceWith(html);}function replacemeinnerwith(id,html) {$('#' + id).html(html);}function initboxed(){$('.materialboxed').materialbox();};function inittooltipped(){$('.tooltipped').tooltip({delay:50});};function initcollapse(id){setactiveheaders(gahret);$('#' + id).collapsible();};function initdropdown(){$('.dropdown-button2').dropdown2();};function SetDisabled(item, b) {$('#' + item).prop('disabled', b)}function SetChecked(item, b) {$('#' + item).prop('checked', b)}function EmptyMe(id) {$('#' + id).empty();}function RemoveMe(id) {$('#' + id).remove();}function RemoveMeParent(id) {$('#' + id).parent().remove();}function AddHTMLPageComponent(html) {$('main').append(html);}function AddHTML(parentid, html) {$('#' + parentid).append(html);}function AddHTMLToMain(html) {$('main').append(html);}function InsertHTMLAfter(parentid, html) {$(html).insertAfter($('#' + parentid));}function InsertHTMLBefore(parentid, html) {$(html).insertBefore($('#' + parentid));}function AddClass(id, cl) {$('#' + id).addClass(cl);}function RemoveClass(id, cl) {$('#' + id).removeClass(cl);}function RunToast(duration, rounded, html, extra, backgroundcolor) {Materialize.toast(html, duration, rounded, function(){b4j_raiseEvent('page_parseevent',{'eventname':'page_toastdismissed','eventparams':'toastid','toastid':extra})});$('#' + extra).parent().css('background-color', backgroundcolor);}function RunToastNoConnection(counter) {Materialize.toast('<span id="toasterror' + counter + '" class="white-text">No connection!</span>',5000,'rounded');$('#toasterror'+counter).parent().css('background-color','#FF0000');}function toastclick(extra, butid) {b4j_raiseEvent('page_parseevent', {'eventname':'page_toastclicked','eventparams':'toastid,action','toastid':extra,'action':butid});}function dismisstoast(toastid) {Vel($('#' + toastid).parent(), {'opacity':0,marginTop:'-40px'},{duration:375,easing:'easeOutExpo',queue:false,complete:function(){$('#' + toastid).parent().remove();}});}function navclick(page, item, url) {if (item!='togglefullscreen') {if ($('#sidenavbutton').is(':visible')) {$('.button-collapse').sideNav('hide');}b4j_raiseEvent('page_parseevent', {'eventname': 'page_navigationbarclicked','eventparams': 'action,value', 'action': item, 'value': url});}}function SetProperty(id, name, value) {$('#' + id).attr(name, value);}function GetProperty(id, name) {return $('#' + id).attr(name);}function SetCSS(id, name, value) {$('#' + id).css(name, value);}function GetCSS(id, name) {return $('#' + id).css(name);}function RemoveProperty(id, name) {$('#' + id).removeAttr(name);}function ShowModal(id, dismissible, size) {initdropdown();InitEditEnterFields();$('#' + id + '_modalcontent').animate({ scrollTop: 0 }, 'fast');$('#' + id).openModal({'dismissible': dismissible, 'end_top': size, 'complete': function() {b4j_raiseEvent('page_parseevent', {'eventname':  'page_modalsheetdismissed','eventparams': 'modalsheetname', 'modalsheetname': id});}});$(window).trigger('resize');$('#' + id).focus();Materialize.updateTextFields();}function ShowModalRelativeCell(id, dismissible, tlcellid, cellwidth) {initdropdown();InitEditEnterFields();var tlcell=$('#' + tlcellid);var mleft=tlcell.offset().left;var mtop=tlcell.offset().top;var windowHeight;if (self.innerHeight) {windowHeight = self.innerHeight;} else if (document.documentElement && document.documentElement.clientHeight) {windowHeight = document.documentElement.clientHeight;} else if (document.body) {windowHeight = document.body.clientHeight;}if ((tlcell[0].getBoundingClientRect().top+tlcell.height()/2)>windowHeight/2) {mtop-=$('#' + id).height();} else {mtop+=tlcell.height();}var mwidth=tlcell.outerWidth();var counter=1;tlcell.siblings().each(function() {if ((counter<cellwidth) && (tlcellid<$(this).attr('id'))) {mwidth+=$(this).outerWidth();counter++;}});$('#' + id + '_modalcontent').animate({ scrollTop: 0 }, 'fast');$('#' + id).css({position: 'absolute',margin: 0, left: mleft, width: mwidth});$('#' + id).openModal({'dismissible': dismissible, 'end_top': mtop, 'complete': function() {b4j_raiseEvent('page_parseevent', {'eventname':  'page_modalsheetdismissed','eventparams': 'modalsheetname', 'modalsheetname': id});}});$('body').css('overflow', '');$(window).trigger('resize');$('#' + id).focus();Materialize.updateTextFields();}function ShowModalRelativeComponent(id, dismissible, tlcellid, fixedwidth) {initdropdown();InitEditEnterFields();var tlcell=$('#' + tlcellid);var mleft=tlcell.offset().left;var mtop=tlcell.offset().top;var windowHeight;if (self.innerHeight) {windowHeight = self.innerHeight;} else if (document.documentElement && document.documentElement.clientHeight) {windowHeight = document.documentElement.clientHeight;} else if (document.body) {windowHeight = document.body.clientHeight;}if ((tlcell[0].getBoundingClientRect().top+tlcell.height()/2)>windowHeight/2) {mtop-=$('#' + id).height();} else {mtop+=tlcell.height();}$('#' + id + '_modalcontent').animate({ scrollTop: 0 }, 'fast');$('#' + id).css({position: 'absolute',margin: 0, left: mleft, width: fixedwidth});$('#' + id).openModal({'dismissible': dismissible, 'end_top': mtop, 'complete': function() {b4j_raiseEvent('page_parseevent', {'eventname':  'page_modalsheetdismissed','eventparams': 'modalsheetname', 'modalsheetname': id});}});$('body').css('overflow', '');$(window).trigger('resize');$('#' + id).focus();Materialize.updateTextFields();}function ShowModalAbsolute(id, dismissible, mleft, mtop, mwidth, mheight) {initdropdown();InitEditEnterFields();$('#' + id + '_modalcontent').animate({ scrollTop: 0 }, 'fast');$('#' + id).css({margin: 0, left: mleft, width: mwidth, height: mheight});$('#' + id).openModal({'dismissible': dismissible, 'end_top': mtop, 'complete': function() {b4j_raiseEvent('page_parseevent', {'eventname':  'page_modalsheetdismissed','eventparams': 'modalsheetname', 'modalsheetname': id});}});$(window).trigger('resize');Materialize.updateTextFields();}function ReShowModal(id) {initdropdown();InitEditEnterFields();$(window).trigger('resize');$('#' + id).focus();Materialize.updateTextFields();}function CloseModal(id) {$('#' + id).closeModal({complete: function() {b4j_raiseEvent('page_parseevent', {'eventname':  'page_modalsheetdismissed','eventparams': 'modalsheetname', 'modalsheetname': id});}});}function fadeinimg(id) {Materialize.fadeInImage('#' + id);}function buttonclickarray(event, par, arrayname, button) {if($('#' + par + arrayname + button).hasClass('disabled')) {return;}if (arrayname=='') {b4j_raiseEvent('page_parseevent', {'eventname': button + '_clicked','eventparams': 'target', 'target': button});} else {b4j_raiseEvent('page_parseevent', {'eventname': arrayname + '_clicked','eventparams': 'target', 'target': button});}}function imageclickarray(event, par, arrayname, image) {if($('#' + par + arrayname + image).hasClass('disabled')) {return;}if (arrayname=='') {b4j_raiseEvent('page_parseevent', {'eventname': image + '_clicked','eventparams': 'target', 'target': image});} else {b4j_raiseEvent('page_parseevent', {'eventname': arrayname + '_clicked','eventparams': 'target', 'target': image});}}function chipclickarray(event, par, arrayname, chip) {if($('#' + par + arrayname + chip).hasClass('disabled')) {return;}if (arrayname=='') {setTimeout(function() { b4j_raiseEvent('page_parseevent', {'eventname': chip + '_clicked','eventparams': 'target', 'target': chip});}, 100);} else {setTimeout(function() { b4j_raiseEvent('page_parseevent', {'eventname': arrayname + '_clicked','eventparams': 'target', 'target': chip});}, 100);}}function chipclosedarray(event, par, arrayname, chip) {if($('#' + par + arrayname + chip).hasClass('disabled')) {return;}if (arrayname=='') {b4j_raiseEvent('page_parseevent', {'eventname': button + '_closed','eventparams': 'target', 'target': chip});} else {b4j_raiseEvent('page_parseevent', {'eventname': arrayname + '_closed','eventparams': 'target', 'target': chip});}}function imagetogglearray(event, par, id, state, src, src2) {if($('#' + par + id).hasClass('disabled')) {return;}$('#' + par + id).attr('abmtoggle', state);$('#' + par + id).attr('src', src);if (state=='0') {$('#' + par + id).attr('onclick', "imagetogglearray(event,'" + par + "','" + id + "','1','" + src2 + "','" + src + "')");} else {$('#' + par + id).attr('onclick', "imagetogglearray(event,'" + par + "','" + id + "','0','" + src2 + "','" + src + "')");}};function inputscrollintofocus(id,smooth) {if (smooth=='0') {$('#' + id).scrollIntoView(false);} else {$('#' + id).scrollIntoView();}}
function tablescrollto(tableid, uniqueid, smooth) {var inner = tableid + '_innerbody';var ypos = $('#' + inner).find('[uniqueid="' + uniqueid + '"]').offset().top;if (smooth=='0') {$('#' + inner).scrollTop($('#' + inner).scrollTop()+ypos);} else {$('#' + inner).animate({scrollTop: $('#' + inner).scrollTop()+ypos}, 300);}}
function inputsetfocus(id) {$('#' + id).focus();}
var gahret=[];function getactiveheaders(id) {gahret=[];$('#' + id).children('li').children('div').each(function () {if ($(this).hasClass('active')){gahret.push($(this).attr('id'));}});};function setactiveheaders(gahret) {var arrayLength = gahret.length;for (var i = 0; i < arrayLength; i++) {$('#' + gahret[i]).addClass('active');$('#' + gahret[i]).addClass('active2');}};function HasClass(id, cl) {var ret='false';if ($('#' + id).hasClass(cl)) {ret='true';}return ret;};function TextAreaResize(item) {$('#' + item).trigger('autoresize')};function TextAreaAllResize() {$('.materialize-textarea').trigger('autoresize')};function saveinlocalstorage(app,login,pwd) {if(typeof(Storage) !== "undefined") {localStorage.setItem('abm' + app + 'login', login);localStorage.setItem('abm' + app + 'pwd', pwd);}};function loadfromlocalstorage(app) {if(typeof(Storage) !== "undefined") {var v1=localStorage.getItem('abm' + app + 'login');var v2=localStorage.getItem('abm' + app + 'pwd');if (v1!==null && v2!==null && v1!=='undefined' && v2!=='undefined' && v1!=='' && v2!=='') {return localStorage.getItem('abm' + app + 'login') + ';' + localStorage.getItem('abm' + app + 'pwd');}}return '';};function clearlocalstorage(app) {if(typeof(Storage) !== "undefined") {localStorage.removeItem('abm' + app + 'login');localStorage.removeItem('abm' + app + 'pwd');}};function customsaveinlocalstorage(key,value) {if(typeof(Storage) !== "undefined") {localStorage.setItem(key, value);}};function customloadfromlocalstorage(key) {if(typeof(Storage) !== "undefined") {return localStorage.getItem(key);}};function customdeletefromlocalstorage(key) {if(typeof(Storage) !== "undefined") {localStorage.removeItem(key);}};function getbrowserwidthheight() {return window.outerWidth+';'+window.outerHeight;};function selectElementContents(el) {var range = document.createRange();range.selectNodeContents(el);var sel = window.getSelection();sel.removeAllRanges();sel.addRange(range);};function InitEditEnterFields() {$('input').unbind("keypress").keypress(function(e){if(e.keyCode==13) {b4j_raiseEvent('page_parseevent', {'eventname': $(this).attr('evname') + '_enterpressed','eventparams': 'value', 'value':$(this).val()});}});$('input').off('keydown').on('keydown', function(e) {if(e.keyCode==9) {b4j_raiseEvent('page_parseevent', {'eventname': $(this).attr('evname') + '_tabpressed','eventparams': 'target,value', 'target':$(this).attr('evname') ,'value':$(this).val()});}});$('.raisechanged').off('change keyup paste').on('change keyup paste', function(e) {if (e.keyCode == 13 || e.keyCode == "undefined") return;b4j_raiseEvent('page_parseevent', {'eventname': $(this).attr('evname') + '_changed','eventparams': 'value', 'value':$(this).val()});});$('.raisechangedcheck').off('change keyup paste').on('change keyup paste', function(e) {if (e.keyCode == 13 || e.keyCode == "undefined") return;b4j_raiseEvent('page_parseevent', {'eventname': $(this).attr('evname') + '_changed','eventparams': 'value', 'value':$(this).val()});if ($(this).hasClass('validateabm')) {$(this).removeClass("invalid");$(this).removeClass("valid");if ($(this).val().length==0) {$(this).addClass("invalid");} else {$(this).addClass("valid");}};});}$.fn.dropdown2=function(t){};