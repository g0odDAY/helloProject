let img=document.createElement('img');
img.setAttribute('src','../imgs/서지수.jpg');
img.setAttribute('id','mypicture');
img.setAttribute('width','600px');
document.getElementById('show').appendChild(img);
console.log(img);

let fruits=['Apple','Banana','Cherry'];
let ul=document.createElement('ul');

/*for(let fruit of fruits){
    let li=document.createElement('li');
    let text=document.createTextNode(fruit);
    li.appendChild(text);
    ul.appendChild(li);  
}*/
fruits.forEach(callBackFnc);

function callBackFnc(item){
    let li = document.createElement('li');
    let text= document.createTextNode(item);
    li.appendChild(text);
    ul.appendChild(li);
}

document.getElementById('bdy').appendChild(ul);

let delBtn=document.getElementById('delBtn');
delBtn.onclick=function(){
    let sname=document.getElementById('sname').value;
    let list= document.querySelectorAll('#nameList>li');
    for(let i=0;i<list.length;i++){
        if(list[i].innerText==sname){
            list[i].remove();
            break;
        }
    }
}
let addBtn=document.getElementById('addBtn');
addBtn.onclick=function(){
    let sname=document.getElementById('sname').value;
    let li=document.createElement('li');
    let text = document.createTextNode(sname);

    li.appendChild(text);
    document.getElementById('nameList').appendChild(li);
}


