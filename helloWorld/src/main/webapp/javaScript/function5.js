
var result=100;


function sum(first,last){
    var result = first+last;
    console.log(result);
}
sum(10,20);
let summay=100;
console.log(summay);

{
    let summay=200;
    console.log(summay);
}
for(var i =0;i<5;i++){
    console.log(i);
}
console.log('-------------');
let myName='hong';
const pi=3.14;
const obj={
    fullName:'kildongHong',
    birth:'1994-04-07',
    score:80,
    showInfo : function(){
        return this.fullName+','+this.birth;
    },
    showAge: function(){
        let today = new Date();
        let birth = new Date(this.birth);
        let age=today-birth;
        age=age/(1000*60*60*24*365);
        console.log(Math.floor(age));
        return age;
    }
}
console.log(obj.fullName);


console.log(obj.showInfo());
console.log(Math.floor(obj.showAge())+'살');