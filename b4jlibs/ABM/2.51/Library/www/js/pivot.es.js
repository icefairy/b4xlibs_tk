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
    return $.pivotUtilities.locales.es = {
      localeStrings: {
        renderError: "Ocurrió un error durante la interpretación de la tabla dinámica.",
        computeError: "Ocurrió un error durante el cálculo de la tabla dinámica.",
        uiRenderError: "Ocurrió un error durante el dibujado de la tabla dinámica.",
        selectAll: "Seleccionar todo",
        selectNone: "Deseleccionar todo",
        tooMany: "(demasiados valores)",
        filterResults: "Filtrar resultados",
        totals: "Totales",
        vs: "vs",
        by: "por"
      },
      aggregators: {
        "Cuenta": tpl.count(frFmtInt),
        "Cuenta de valores únicos": tpl.countUnique(frFmtInt),
        "Lista de valores únicos": tpl.listUnique(", "),
        "Suma": tpl.sum(frFmt),
        "Suma de enteros": tpl.sum(frFmtInt),
        "Promedio": tpl.average(frFmt),
        "Mínimo": tpl.min(frFmt),
        "Máximo": tpl.max(frFmt),
		"Primero": tpl.first(frFmt),
		"Ultimo": tpl.last(frFmt),
        "Suma de sumas": tpl.sumOverSum(frFmt),
        "Cota 80% superior": tpl.sumOverSumBound80(true, frFmt),
        "Cota 80% inferior": tpl.sumOverSumBound80(false, frFmt),
        "Proporción del total (suma)": tpl.fractionOf(tpl.sum(), "total", frFmtPct),
        "Proporción de la fila (suma)": tpl.fractionOf(tpl.sum(), "row", frFmtPct),
        "Proporción de la columna (suma)": tpl.fractionOf(tpl.sum(), "col", frFmtPct),
        "Proporción del total (cuenta)": tpl.fractionOf(tpl.count(), "total", frFmtPct),
        "Proporción de la fila (cuenta)": tpl.fractionOf(tpl.count(), "row", frFmtPct),
        "Proporción de la columna (cuenta)": tpl.fractionOf(tpl.count(), "col", frFmtPct)
      },
	   aggregatorsMap: {
        "Count": "Cuenta",
        "Count Unique Values": "Cuenta de valores únicos",
        "List Unique Values": "Lista de valores únicos",
        "Sum": "Suma",
        "Integer Sum": "Suma de enteros",
        "Average": "Promedio",
        "Minimum": "Mínimo",
        "Maximum": "Máximo",
		"First": "Primero",
		"Last": "Ultimo",
        "Sum over Sum": "Suma de sumas",
        "80% Upper Bound": "Cota 80% superior",
        "80% Lower Bound": "Cota 80% inferior",
        "Sum as Fraction of Total": "Proporción del total (suma)",
        "Sum as Fraction of Rows": "Proporción de la fila (suma)",
        "Sum as Fraction of Columns": "Proporción de la columna (suma)",
        "Count as Fraction of Total": "Proporción del total (cuenta)",
        "Count as Fraction of Rows": "Proporción de la fila (cuenta)",
        "Count as Fraction of Columns": "Proporción de la columna (cuenta)"
      },
      renderers: {
        "Tabla": $.pivotUtilities.renderers["Table"],
        "Tabla con barras": $.pivotUtilities.renderers["Table Barchart"],
        "Heatmap": $.pivotUtilities.renderers["Heatmap"],
        "Heatmap por filas": $.pivotUtilities.renderers["Row Heatmap"],
        "Heatmap por columnas": $.pivotUtilities.renderers["Col Heatmap"]
      },
	  renderersMap: {
		 "Table": "Tabla",
		 "Table Barchart": "Tabla con barras",
		 "Heatmap": "Heatmap",
		 "Row Heatmap": "Heatmap por filas",
		 "Col Heatmap": "Heatmap por columnas",
		 "Table With Subtotal": "Tabla",
		 "Table With Subtotal Bar Chart": "Tabla con barras",
		 "Table With Subtotal Heatmap": "Heatmap",
		 "Table With Subtotal Row Heatmap": "Heatmap por filas",
		 "Table With Subtotal Col Heatmap": "Heatmap por columnas",
		 "TSV Export": "TSV Export",
		 "Line Chart": "Gráfico de linea",
		 "Bar Chart": "Gráfico de barras",
		 "Stacked Bar Chart": "Gráfico de barras apiladas",
		 "Area Chart": "Gráfico de área",
		 "Scatter Chart": "Gráfico de dispersión"		 
	  }
    };
  });

}).call(this);

//# sourceMappingURL=pivot.es.js.map