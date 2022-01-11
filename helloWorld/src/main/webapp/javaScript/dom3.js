let div=document.createElement('div');

div.setAttribute('id','show');
console.log(div);
let input=document.createElement('input');
input.setAttribute('type','text');
input.setAttribute('value','test');
console.log(input);
div.appendChild(input);
console.log(div);
let addBtn=document.createElement('button');
addBtn.innerHTML='추가';
console.log(addBtn);
let delBtn=document.createElement('button');
delBtn.innerHTML='삭제';
console.log(delBtn);
div.appendChild(addBtn);
div.appendChild(delBtn);
console.log(div);

let ul=document.createElement('ul');
//반복
let members=['김은서','황보경','고권영','류기태','구자현','황규복'];

for(let list of members){
    let li=document.createElement('li');
    li.innerHTML=list;
    div.appendChild(ul).appendChild(li);
}

/*
let li=document.createElement('li');
li.innerHTML='김은서';
div.appendChild(ul).appendChild(li);

li=document.createElement('li');
li.innerHTML='황보경';
div.appendChild(ul).appendChild(li);

li=document.createElement('li');
li.innerHTML='고권영';
div.appendChild(ul).appendChild(li);

li=document.createElement('li');
li.innerHTML='류기태';
div.appendChild(ul).appendChild(li);

li=document.createElement('li');
li.innerHTML='구자현';
div.appendChild(ul).appendChild(li);*/
//반복끝
let body=document.getElementById('bdy');

body.appendChild(div);

