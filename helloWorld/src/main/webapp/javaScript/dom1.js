let pelement=document.querySelector('body>p');
console.log(pelement);
pelement.innerHTML='not Hello';
let newP=document.createElement('p');
newP.innerHTML='fuxk hello';
console.log(newP);

pelement.after(newP);
let list = document.querySelectorAll('ul>li');

console.log(list);

document.getElementById('delBtn').onclick=function(){
    let sname=document.getElementById('sname').value;
    let liTag=document.createElement('li');
    liTag.innerHTML=sname;
    let ul=document.querySelector('ul');
    ul.appendChild(liTag);

}