$(document).ready(function(){
	$("a.button").button();
	$("input:submit.button").button();
	$.ajaxSetup({
		cache: false
	});
});

function formatTime(timestamp)
{
	var date=new Date(Number(timestamp));
	var h=date.getHours();
	var m=date.getMinutes();
	var s=date.getSeconds();
	// add a zero in front of numbers<10
	m=checkTime(m);
	s=checkTime(s);
	return h+":"+m+":"+s;
}

function checkTime(i){
	if (i<10) 
		i="0" + i;
	return i;
}