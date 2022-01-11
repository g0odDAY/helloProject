let str=` <table border="1">
<thead>
<tr>    
    <th>이름</th>
    <th>전화번호</th>
    <th>주소</th>
    <th>삭제</th>
</tr>
</thead>
<tbody>
    <tr>
        <td>홍길동</td>
        <td>054-471-5452</td>
        <td>대구 중구 456번지</td>
        <td><button>삭제</button></td>
    </tr>
    <tr>
        <td>황규복</td>
        <td>054-471-2223</td>
        <td>대구 중구 456번지</td>
        <td><button>삭제</button></td>
    </tr>
    <tr>
        <td>박성헌</td>
        <td>053-472-4556</td>
        <td>대구 달서구 456번지</td>
        <td><button>삭제</button></td>
    </tr>
</tbody>
</table>`;

document.write(str);

let names=document.querySelectorAll('table>tbody>tr>td:nth-child(1)');
console.log(names);
for(let i=0;i<names.length;i++){
    names[i].onclick=function(e){
        console.log(e.target.innerText);
        let text=e.target.innerText;
        alert(text+'입니다.');
    }
}
let rows=document.querySelectorAll('tbody>tr');
console.log(rows);
for(let i =0;i<rows.length;i++){
    rows[i].onmouseover=function(e){
        console.log(e.target.parentNode);
        e.target.parentNode.style.backgroundColor='yellow';
        //e.target.parentNode.style.display='none';
    }//<div style='background-color:yellow;'></div>
    rows[i].onmouseout=function(e){
        console.log(e.target.parentNode);
        e.target.parentNode.style.backgroundColor=null;
    }
}
let btns=document.querySelectorAll('table>tbody>tr>td>button');
console.log(btns);
for(let i=0;i<btns.length;i++){
    btns[i].addEventListener('click',deleteFnc);
}

function deleteFnc(e){
    e.target.parentNode.parentNode.remove();
}