<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>开奖数据</title>
<link rel="stylesheet" href="main.css">
<meta name="viewport" content="width=device-width">
<script>
function myrefresh(){
var date=new Date();
var hours = date.getHours();
if(hours>2&&hours<10){
	showmsg('02:00-10:00无新数据不刷新');
}else{
   window.location.reload();
}
}
setTimeout('myrefresh()',30000); //指定60秒刷新一次
function getbyid(id){
	return document.getElementById(id);
}
function formatAMPM(date) {
  var hours = date.getHours();
  var minutes = date.getMinutes();
  var seconds=date.getSeconds();
 if(hours<10){
	hours='0'+hours;
	}
  minutes = minutes < 10 ? '0'+minutes : minutes;
  seconds = seconds < 10 ? '0'+seconds : seconds;
  var strTime = hours + ':' + minutes+':'+seconds ;
  return strTime;
}
function showmsg(msg){
var pmsg=getbyid('pmsg');
if(pmsg!=null){
pmsg.innerHTML=msg;
}}</script>
</head>
<body align="center" onload="showmsg('最后刷新时间 '+formatAMPM(new Date()));"><div id="main"><p id='pmsg'></p><div id="divcontent">