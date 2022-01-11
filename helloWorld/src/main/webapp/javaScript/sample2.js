function addNumber(n1,n2){
    var sum=n1+n2;
    console.log(`합계는${sum}`);
    
}
addNumber(5,11);
function showNumber(yourName,yourScore){
    document.write(`<p>이름: ${yourName},점수: ${yourScore}</p>`);
}
showNumber('홍길동',80);

var students=[
    {studentName:'홍길동',score:90},
    {studentName:'황규복',score:80},
    {studentName:'권동환',score:55}
];
for(var student of students){
    document.write(`<p>이름: ${student.studentName},점수: ${student.score}</p>`);

}
var today=new Date();
function showInfo(yourName,birthYear){
    
    document.write(`<p>이름 : ${yourName},나이 : ${today.getFullYear()-birthYear}</p>`);
}
showInfo('홍길동',1994);
var members=[
    {memberName:'홍길동',memberAge:1994},
    {memberName:'황규복',memberAge:1994},
    {memberName:'권동환',memberAge:1993},
    {memberName:'정충명',memberAge:1998},
]
for(var member of members){
    document.write(`<p>이름 : ${member.memberName},나이 : ${today.getFullYear()-member.memberAge}</p>`)
}