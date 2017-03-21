(function() {
  var callWithJQuery;

  callWithJQuery = function(pivotModule) {
    if (typeof exports === "object" && typeof module === "object") {
      return pivotModule(require("jquery"));
    } else if (typeof define === "function" && define.amd) {
      return define(["jquery"], pivotModule);
    } else {
      return pivotModule(jQuery);
    }
  };

  callWithJQuery(function($) {
    var frFmt, frFmtInt, frFmtPct, nf, tpl;
    nf = $.pivotUtilities.numberFormat;
    tpl = $.pivotUtilities.aggregatorTemplates;
    frFmt = nf({
      thousandsSep: " ",
      decimalSep: ","
    });
    frFmtInt = nf({
      digitsAfterDecimal: 0,
      thousandsSep: " ",
      decimalSep: ","
    });
    frFmtPct = nf({
      digitsAfterDecimal: 1,
      scaler: 100,
      suffix: "%",
      thousandsSep: " ",
      decimalSep: ","
    });
    return $.pivotUtilities.locales.nl = {
      localeStrings: {
        renderError: "Er is een fout opgetreden bij het renderen van de kruistabel.",
        computeError: "Er is een fout opgetreden bij het berekenen van de kruistabel.",
        uiRenderError: "Er is een fout opgetreden bij het tekenen van de interface van de kruistabel.",
        selectAll: "Alles selecteren",
        selectNone: "Niets selecteren",
        tooMany: "(te veel waarden om weer te geven)",
        filterResults: "Filter resultaten",
        totals: "Totaal",
        vs: "versus",
        by: "per"
      },
      aggregators: {
        "Aantal": tpl.count(frFmtInt),
        "Aantal unieke waarden": tpl.countUnique(frFmtInt),
        "Lijst unieke waarden": tpl.listUnique(", "),
        "Som": tpl.sum(frFmt),
        "Som van gehele getallen": tpl.sum(frFmtInt),
        "Gemiddelde": tpl.average(frFmt),
        "Minimum": tpl.min(frFmt),
        "Maximum": tpl.max(frFmt),
		"Eerste": tpl.first(frFmt),
		"Laatste": tpl.last(frFmt),
        "Som over som": tpl.sumOverSum(frFmt),
        "80% bovengrens": tpl.sumOverSumBound80(true, frFmt),
        "80% ondergrens": tpl.sumOverSumBound80(false, frFmt),
        "Som in verhouding tot het totaal": tpl.fractionOf(tpl.sum(), "total", frFmtPct),
        "Som in verhouding tot de rij": tpl.fractionOf(tpl.sum(), "row", frFmtPct),
        "Som in verhouding tot de kolom": tpl.fractionOf(tpl.sum(), "col", frFmtPct),
        "Aantal in verhouding tot het totaal": tpl.fractionOf(tpl.count(), "total", frFmtPct),
        "Aantal in verhouding tot de rij": tpl.fractionOf(tpl.count(), "row", frFmtPct),
        "Aantal in verhouding tot de kolom": tpl.fractionOf(tpl.count(), "col", frFmtPct)
      },
	  aggregatorsMap: {
        "Count": "Aantal",
        "Count Unique Values": "Aantal unieke waarden",
        "List Unique Values": "Lijst unieke waarden",
        "Sum": "Som",
        "Integer Sum": "Som van gehele getallen",
        "Average": "Gemiddelde",
        "Minimum": "Minimum",
        "Maximum": "Maximum",
		"First": "Eerste",
		"Last": "Laatste",
        "Sum over Sum": "Som over som",
        "80% Upper Bound": "80% bovengrens",
        "80% Lower Bound": "80% ondergrens",
        "Sum as Fraction of Total": "Som in verhouding tot het totaal",
        "Sum as Fraction of Rows": "Som in verhouding tot de rij",
        "Sum as Fraction of Columns": "Som in verhouding tot de kolom",
        "Count as Fraction of Total": "Aantal in verhouding tot het totaal",
        "Count as Fraction of Rows": "Aantal in verhouding tot de rij",
        "Count as Fraction of Columns": "Aantal in verhouding tot de kolom"
      },
      renderers: {
        "Tabel": $.pivotUtilities.renderers["Table"],
        "Tabel met staafdiagrammen": $.pivotUtilities.renderers["Table Barchart"],
        "Warmtekaart": $.pivotUtilities.renderers["Heatmap"],
        "Warmtekaart per rij": $.pivotUtilities.renderers["Row Heatmap"],
        "Warmtekaart per kolom": $.pivotUtilities.renderers["Col Heatmap"]
      },
	  renderersMap: {
		 "Table": "Tabel",
		 "Table Barchart": "Tabel met staafdiagrammen",
		 "Heatmap": "Warmtekaart",
		 "Row Heatmap": "Warmtekaart per rij",
		 "Col Heatmap": "Warmtekaart per kolom",
		 "Table With Subtotal": "Tabel",
		 "Table With Subtotal Bar Chart": "Tabel met staafdiagrammen",
		 "Table With Subtotal Heatmap": "Warmtekaart",
		 "Table With Subtotal Row Heatmap": "Warmtekaart per rij",
		 "Table With Subtotal Col Heatmap": "Warmtekaart per kolom",
		 "TSV Export": "TSV Export",
		 "Line Chart": "Lijndiagram",
		 "Bar Chart": "Staafdiagram",
		 "Stacked Bar Chart": "Gestapeld Staafdiagram",
		 "Area Chart": "Oppervlaktediagram",
		 "Scatter Chart": "Spreidingsdiagram"		 
	  }
    };
  });

}).call(this);

//# sourceMappingURL=pivot.nl.js.map