var member1={
    memberId:1001,
    memberName:'홍길동',
    memberPhone:'010-3957-5452',
    memberAddr:'Daegu 100'
}
var member2={
    memberId:1002,
    memberName:'김도연',
    memberPhone:'010-4557-4856',
    memberAddr:'Daegu 200'
}
var member3={
    memberId:1003,
    memberName:'차주연',
    memberPhone:'010-3333-3333',
    memberAddr:'Daegu 300'
}
var member4={
    memberId:1004,
    memberName:'전호민',
    memberPhone:'010-4868-4443',
    memberAddr:'Daegu 400'
}

var members=[member1,member2,member3,member4];
var str='';
str+='<table id="tbl" border="1">';
str+='<thead><tr>';
for(var field in member1){
    str+=`<th>${field}</th>`;
}
str+='</tr></thead>';
str+='<tbody>';
for(var member of members){
    str+='<tr>';
   for(var field in member){   
   str+=`<td>${member[field]}</td>`;
} 
str+='</tr>';
}

str+='</tbody></table>';

document.write(str);

