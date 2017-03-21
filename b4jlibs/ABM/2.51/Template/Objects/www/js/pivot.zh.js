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
    var c3r, d3r, frFmt, frFmtInt, frFmtPct, gcr, nf, r, tpl;
    nf = $.pivotUtilities.numberFormat;
    tpl = $.pivotUtilities.aggregatorTemplates;
    r = $.pivotUtilities.renderers;
    gcr = $.pivotUtilities.gchart_renderers;
    d3r = $.pivotUtilities.d3_renderers;
    c3r = $.pivotUtilities.c3_renderers;
    frFmt = nf({
      thousandsSep: ",",
      decimalSep: "."
    });
    frFmtInt = nf({
      digitsAfterDecimal: 0,
      thousandsSep: ",",
      decimalSep: "."
    });
    frFmtPct = nf({
      digitsAfterDecimal: 2,
      scaler: 100,
      suffix: "%",
      thousandsSep: ",",
      decimalSep: "."
    });
    return $.pivotUtilities.locales.zh = {
      localeStrings: {
        renderError: "展示结果时出错。",
        computeError: "计算结果时出错。",
        uiRenderError: "展示界面时出错。",
        selectAll: "选择全部",
        selectNone: "全部不选",
        tooMany: "(因数据过多而无法列出)",
        filterResults: "输入值帮助筛选",
        totals: "合计",
        vs: "于",
        by: "分组于"
      },
      aggregators: {
        "频数": tpl.count(frFmtInt),
        "非重复值的个数": tpl.countUnique(frFmtInt),
        "列出非重复值": tpl.listUnique(", "),
        "求和": tpl.sum(frFmt),
        "求和后取整": tpl.sum(frFmtInt),
        "平均值": tpl.average(frFmt),
        "最小值": tpl.min(frFmt),
        "最大值": tpl.max(frFmt),
		"第一": tpl.first(frFmt),
		"最后": tpl.last(frFmt),
        "两和之比": tpl.sumOverSum(frFmt),
        "二项分布：置信度为80%时的区间上限": tpl.sumOverSumBound80(true, frFmt),
        "二项分布：置信度为80%时的区间下限": tpl.sumOverSumBound80(false, frFmt),
        "和在总计中的比例": tpl.fractionOf(tpl.sum(), "total", frFmtPct),
        "和在行合计中的比例": tpl.fractionOf(tpl.sum(), "row", frFmtPct),
        "和在列合计中的比例": tpl.fractionOf(tpl.sum(), "col", frFmtPct),
        "频数在总计中的比例": tpl.fractionOf(tpl.count(), "total", frFmtPct),
        "频数在行合计中的比例": tpl.fractionOf(tpl.count(), "row", frFmtPct),
        "频数在列合计中的比例": tpl.fractionOf(tpl.count(), "col", frFmtPct)
      },	  
	  aggregatorsMap: {
        "Count": "频数",
        "Count Unique Values": "非重复值的个数",
        "List Unique Values": "列出非重复值",
        "Sum": "求和",
        "Integer Sum": "求和后取整",
        "Average": "平均值",
        "Minimum": "最小值",
        "Maximum": "最大值",
		"First": "第一",
		"Last": "最后",
        "Sum over Sum": "两和之比",
        "80% Upper Bound": "二项分布：置信度为80%时的区间上限",
        "80% Lower Bound": "二项分布：置信度为80%时的区间下限",
        "Sum as Fraction of Total": "和在总计中的比例",
        "Sum as Fraction of Rows": "和在行合计中的比例",
        "Sum as Fraction of Columns": "和在列合计中的比例",
        "Count as Fraction of Total": "频数在总计中的比例",
        "Count as Fraction of Rows": "频数在行合计中的比例",
        "Count as Fraction of Columns": "频数在列合计中的比例"
      },
      renderers: {
        "表格": r["Table"],
        "表格内柱状图": r["Table Barchart"],
        "热图": r["Heatmap"],
        "行热图": r["Row Heatmap"],
        "列热图": r["Col Heatmap"]
      },
	  renderersMap: {
		 "Table": "表格",
		 "Table Barchart": "表格内柱状图",
		 "Heatmap": "热图",
		 "Row Heatmap": "行热图",
		 "Col Heatmap": "Warmtekaart per kolom",
		 "Table With Subtotal": "表格",
		 "Table With Subtotal Bar Chart": "表格内柱状图",
		 "Table With Subtotal Heatmap": "热图",
		 "Table With Subtotal Row Heatmap": "行热图",
		 "Table With Subtotal Col Heatmap": "列热图",
		 "TSV Export": "TSV Export",
		 "折线图": "Lijndiagram",
		 "柱状图": "Staafdiagram",
		 "Stacked Bar Chart": "堆叠柱状图",
		 "Area Chart": "面积图",
		 "Scatter Chart": "散点图"		 
	  }
    };
  });

}).call(this);

//# sourceMappingURL=pivot.zh.js.map