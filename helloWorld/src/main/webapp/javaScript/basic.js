var v1;
var myname="hong";
v1 = "hello world";
v1 ='nice, world';
v1 ='nice, "world"';
v1='nice,' + myname;
v1= `nice, ${myname}`;
v1=3.14;
var v2=10;
var result=v1+v2;

var trueOfFalse='';

if(trueOfFalse){
    console.log("참입니다.");
}


console.log(result);
console.log(typeof result);


var str='<ul>';
str +='<li>Apple</li>';
str +='<li>Banana</li>';
str +='</ul>';  
document.write(str);

var  num1=10;
function f1(){
    var num1=20;
    console.log('local: '+num1);
}
f1();
console.log('global: '+num1);
var day=new Date(2021,12,05);
document.write(day);