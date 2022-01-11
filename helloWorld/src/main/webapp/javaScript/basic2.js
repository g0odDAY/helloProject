'use strict'
var fruits=['Apple','Banana','Cherry'];
var str='';
//document.write('<ul>');
str+='<ul>';
for(var i=0;i<fruits.length;i++){
    console.log(fruits[i]);
    str+=`<li>${fruits[i]}</li>`
   // document.write('<li>'+fruits[i]+'</li>');
}
str+='</ul>';
//document.write('</ul>');
document.write(str);
var numbers=[10,20,30];
var sum=0;
for(var i=0;i<numbers.length;i++){
    sum+=numbers[i];
}
console.log(`합계:${sum}`);
var student1={
    name:'hong',
    age:20,
    score:80
};
for(var field in student1){
    console.log(field,student1[field]);
}
console.log(student1.name);
console.log(student1.age);
console.log(student1.score);
var student2={
    name:'Hwang',
    age:22,
    score:83
};
var student3={
    name:'Park',
    age:25,
    score:99
};
var students = [student1,student2,student3];

str='';
str +='<table border="1">';
str +='<thead><tr>';
for(var field in student1){
    str+=`<th>${field}</th>`;
}
str+='</tr></thead>';
str+='<tbody>';
for(var i=0;i<students.length;i++){
    console.log(`name=> ${students[i].name}`);
    console.log(`name=> ${students[i].age}`);
    console.log(`name=> ${students[i].score}`);
    str+='<tr>';
    for(var field in student1){
        str+=`<td>${students[i][field]}</td>`;
    }
    str='</tr>';
}
str +='</tbody></table>';
document.write(str);
