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
    return $.pivotUtilities.locales.fr = {
      localeStrings: {
        renderError: "Une erreur est survenue en dessinant le tableau croisé.",
        computeError: "Une erreur est survenue en calculant le tableau croisé.",
        uiRenderError: "Une erreur est survenue en dessinant l'interface du tableau croisé dynamique.",
        selectAll: "Sélectionner tout",
        selectNone: "Sélectionner rien",
        tooMany: "(trop de valeurs à afficher)",
        filterResults: "Filtrer les valeurs",
        totals: "Totaux",
        vs: "sur",
        by: "par",
        apply: "Appliquer",
        cancel: "Annuler"
      },
      aggregators: {
        "Nombre": tpl.count(frFmtInt),
        "Nombre de valeurs uniques": tpl.countUnique(frFmtInt),
        "Liste de valeurs uniques": tpl.listUnique(", "),
        "Somme": tpl.sum(frFmt),
        "Somme en entiers": tpl.sum(frFmtInt),
        "Moyenne": tpl.average(frFmt),
        "Minimum": tpl.min(frFmt),
        "Maximum": tpl.max(frFmt),
        "Premier": tpl.min(frFmt),
        "Dernier": tpl.max(frFmt),
        "Ratio de sommes": tpl.sumOverSum(frFmt),
        "Borne supérieure 80%": tpl.sumOverSumBound80(true, frFmt),
        "Borne inférieure 80%": tpl.sumOverSumBound80(false, frFmt),
        "Somme en proportion du totale": tpl.fractionOf(tpl.sum(), "total", frFmtPct),
        "Somme en proportion de la ligne": tpl.fractionOf(tpl.sum(), "row", frFmtPct),
        "Somme en proportion de la colonne": tpl.fractionOf(tpl.sum(), "col", frFmtPct),
        "Nombre en proportion du totale": tpl.fractionOf(tpl.count(), "total", frFmtPct),
        "Nombre en proportion de la ligne": tpl.fractionOf(tpl.count(), "row", frFmtPct),
        "Nombre en proportion de la colonne": tpl.fractionOf(tpl.count(), "col", frFmtPct)
      },
	   aggregatorsMap: {
        "Count": "Nombre",
        "Count Unique Values": "Nombre de valeurs uniques",
        "List Unique Values": "Liste de valeurs uniques",
        "Sum": "Somme",
        "Integer Sum": "Somme en entiers",
        "Average": "Moyenne",
        "Minimum": "Minimum",
        "Maximum": "Maximum",
		"First": "Premier",
		"Last": "Dernier",
        "Sum over Sum": "Ratio de sommes",
        "80% Upper Bound": "Borne supérieure 80%",
        "80% Lower Bound": "Borne inférieure 80%",
        "Sum as Fraction of Total": "Somme en proportion du totale",
        "Sum as Fraction of Rows": "Somme en proportion de la ligne",
        "Sum as Fraction of Columns": "Somme en proportion de la colonne",
        "Count as Fraction of Total": "Nombre en proportion du totale",
        "Count as Fraction of Rows": "Nombre en proportion de la ligne",
        "Count as Fraction of Columns": "Nombre en proportion de la colonne"
      },
      renderers: {
        "Table": $.pivotUtilities.renderers["Table"],
        "Table avec barres": $.pivotUtilities.renderers["Table Barchart"],
        "Carte de chaleur": $.pivotUtilities.renderers["Heatmap"],
        "Carte de chaleur par ligne": $.pivotUtilities.renderers["Row Heatmap"],
        "Carte de chaleur par colonne": $.pivotUtilities.renderers["Col Heatmap"]
      },
	  renderersMap: {
		 "Table": "Table",
		 "Table Barchart": "Table avec barres",
		 "Heatmap": "Carte de chaleur",
		 "Row Heatmap": "Carte de chaleur par ligne",
		 "Col Heatmap": "Carte de chaleur par colonne",
		 "Table With Subtotal": "Table",
		 "Table With Subtotal Bar Chart": "Table avec barres",
		 "Table With Subtotal Heatmap": "Carte de chaleur",
		 "Table With Subtotal Row Heatmap": "Carte de chaleur par ligne",
		 "Table With Subtotal Col Heatmap": "Carte de chaleur par colonne",
		 "TSV Export": "TSV Export",
		 "Line Chart": "Graphique lignes",
		 "Bar Chart": "Graphique barres",
		 "Stacked Bar Chart": "Graphique barres superposées",
		 "Area Chart": "Graphique aires",
		 "Scatter Chart": "Graphique dispersion"		 
	  }
    };
  });

}).call(this);

//# sourceMappingURL=pivot.fr.js.map