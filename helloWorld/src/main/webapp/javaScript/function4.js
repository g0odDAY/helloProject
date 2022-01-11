var students=[
    {studentName:'홍길동',score:90,birth:'1994-05-01',phone:'010-5454-4485',gender:'남자'},
    {studentName:'황규복',score:80,birth:'1950-11-03',phone:'010-7786-8845',gender:'남자'},
    {studentName:'권동환',score:55,birth:'1988-08-08',phone:'010-8888-7777',gender:'남자'}
];
function makeTable(arry){
    var str=' ';
    str+=`<table border='1'>`;
    str+=`<thead><tr><th>이름</th><th>점수</th><th>생년월일</th><th>연락처</th><th>성별</th></tr></thead>`;
    str+=`<tbody>`;
    for(var student of arry){
        str += '<tr>';
        for(var field in student){
            str += `<td>${student[field]}</td>`;
        
        }
        
        str +='</tr>';
    }
    str+=`</tbody>`;

    str+=`</table>`;
    return str;
}
document.write(makeTable(students));