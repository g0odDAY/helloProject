let delBtn=document.getElementById('delBtn');
delBtn.onclick=function(){
    let sname=document.getElementById('sname').value;

    if(!sname){
        alert('값을 입력하세요!!');
        return;
    }
    let list=document.querySelectorAll('ul>li');
    console.log(list);
    for(let i=0;i<list.length;i++){
        if(list[i].innerText==sname){
            list[i].style.display='none';
        }
    }
}










const numArry=[23,17,33,72,88];
let sum=0;
numArry.forEach(function(item,idx,arry){
    if(idx%2==0){
        sum+=item;
    }
    
});
console.log(`합계: ${sum}`);
let cnt=0;
const names=['김은서','황보경','고권영','류기태','구자현'];
for(let tmp of names){
    cnt++;
    if(tmp==name){
        console.log(cnt);
    }
}
/*for(let i =0;i<1;i++){
   const name = window.prompt('삭제할 이름  입력>>');
    names.pop(name);
}*/
//names.splice(1,0,'누군가');

console.log(names);

/*
document.write('<ul>');
for(var i=0;i<numArry.length;i++){
    document.write('<li>'+numArry[i] +'</li>');
}
document.write('</ul>');

let list=document.querySelectorAll('ul:nth-of-type(1)>li');

list.forEach(function(item,idx,arry){
    //console.log(item,idx,arry);
    console.log(item.innerHTML);
    if(idx % 2 == 0){
        item.innerHTML='<h3>hello</h3>';
    }
    
});
*/
