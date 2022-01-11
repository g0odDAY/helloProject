const students=[
    {fullName:'류지희',stdNo:'1001',score:80},
    {fullName:'차주연',stdNo:'1002',score:50},
    {fullName:'전호민',stdNo:'1003',score:100}
];

document.write('<ul>');
for(let tmp of students){
   document.write(`<li>이름:${tmp.fullName},학번:${tmp.stdNo},점수:${tmp.score}</li>`);
}
document.write('</ul>');
students.push({
    fullName:'홍정우',
    stdNo:'1004',
    score:55
})
document.write('<ul>');
students.forEach(liFnc);
document.write('</ul>');

function liFnc(item){
    document.write(`<li>${item.fullName}-${item.stdNo}-${item.score}</li>`);
}

const numArry=[1,2,3];
numArry.push(4);
numArry.unshift(99);
console.log(numArry);