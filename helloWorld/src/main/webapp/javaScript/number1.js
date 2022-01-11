let num=100.123;
console.log(Math.floor(num));
console.log(Math.ceil(num));
let temp=Math.random();
console.log(temp);
temp=Math.random()*5;
console.log(Math.floor(temp));


let findVal=1;
let order=parseInt(Math.random()*9);
for(let i =0;i < 9;i++){
    let temp = parseInt(Math.random()*9)+1;
    document.write(`<div>${temp}</div>`);
    if(i%3==2){
        document.write(`<br>`);
    }
    if(i==order){
        findVal=temp;
    }
}
window.alert(findVal+'을 찾으세요');
function clickFnc(e){
    console.log(e.target.innerText);
    if(e.target.innerText==findVal){
        window.alert(findVal+'를 찾앗습니다.');
        e.target.style.color='blue';
    }
    //window.alert(e.target.innerText);
}
let divElement=document.getElementsByTagName('div');
console.log(divElement);
for(let i=0;i<divElement.length;i++){
        divElement[i].onclick=clickFnc; 
}
