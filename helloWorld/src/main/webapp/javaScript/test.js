const bookInfo=[
    {bookCode:'p445656',bookName:'이것이 자바다1',bookWriter:'홍성운',bookPublishing:'예담출판사',bookPrice:'25,000원'},
    {bookCode:'p445656',bookName:'이것이 자바다2',bookWriter:'홍성운',bookPublishing:'예담출판사',bookPrice:'25,000원'},
    {bookCode:'p445656',bookName:'이것이 자바다3',bookWriter:'홍성운',bookPublishing:'예담출판사',bookPrice:'25,000원'},
    {bookCode:'p445656',bookName:'이것이 자바다4',bookWriter:'홍성운',bookPublishing:'예담출판사',bookPrice:'25,000원'},
    {bookCode:'p445656',bookName:'이것이 자바다5',bookWriter:'홍성운',bookPublishing:'예담출판사',bookPrice:'25,000원'}
];


let table=document.createElement('table');
table.setAttribute('border','1');
table.appendChild(makeHead());
table.appendChild(makeBody());
let list=document.getElementById('list');
list.appendChild(table);
console.log(list);


function makeHead(){
    const titles=['도서코드','도서명','저자','출판사','가격','삭제'];
    let thead=document.createElement('thead');
    let tr=document.createElement('tr');

    //checkbox
    let th=document.createElement('th');
    let checkbox=document.createElement('input');
    checkbox.setAttribute('type','checkbox');
   
    checkbox.addEventListener('change',allCheckFnc);
    th.appendChild(checkbox);
    tr.appendChild(th);

    titles.forEach(function(i){
    let th=document.createElement('th');
    let text=document.createTextNode(i);
    th.appendChild(text);
    tr.appendChild(th);
    });
    thead.appendChild(tr);
    return thead;
};

function allCheckFnc() {
    console.log(this.checked);
    let chks = document.querySelectorAll('tbody input[type="checkbox"]');
    console.log(chks);
    for (var i = 0; i < chks.length; i++) {
        console.log(chks[i]);
        chks[i] = this.checked;
    }
}

function makeBody(){
    let tbody=document.createElement('tbody');
    
    bookInfo.forEach(function(i){
        tbody.appendChild(makeTr(i));
    });

    return tbody;
    
};
function makeTr(i){
    let tr=document.createElement('tr');
    
    //체크박스
    let td = document.createElement('td');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox');
    td.appendChild(checkbox);
    tr.appendChild(td);

    for(let data in i){
    let text=document.createTextNode(i[data]);   
    let td=document.createElement('td');   
    td.appendChild(text);
    tr.appendChild(td);
    }
    
    //삭제버튼
    td = document.createElement('td');
    let delBtn = document.createElement('button');
    console.log(delBtn);
    delBtn.setAttribute('id','del');
    delBtn.innerHTML="삭제";
    td.appendChild(delBtn);
    tr.appendChild(td);

    return tr;

}
let addBtn=document.querySelector('#btn>button');
console.log(addBtn);
addBtn.addEventListener('click',addCallback);
function addCallback(){
    let bookCode=document.querySelector('input[name="bookCode"]').value;
    let bookName=document.querySelector('input[name="bookName"]').value;
    let bookWriter=document.querySelector('input[name="writer"]').value;
    let bookPublishing=document.querySelector('input[name="publishing"]').value;
    let bookPrice=document.querySelector('input[name="bookPrice"]').value;
    let obj={
        bookCode:bookCode,
        bookName:bookName,
        bookWriter:bookWriter,
        bookPublishing:bookPublishing,
        bookPrice:bookPrice
    } ;
    let tr=makeTr(obj);
    document.querySelector('#list>table>tbody').appendChild(tr);
}
let delBtn=document.querySelector('#btn>button:nth-child(2)');
delBtn.addEventListener('click',delCallback);
console.log(delBtn);
function delCallback(){
    let chks=document.querySelectorAll('tbody input[type="checkbox"]');
    console.log(chks);
    for(let i=0;i<chks.length;i++){
        
        if(chks[i].checked==true){
           // console.log(chks[i].parentNode);
            chks[i].parentNode.parentNode.remove();
        }
    }
};

let del=document.querySelectorAll('#del');
console.log(del);
for(let i=0;i<del.length;i++){
    del[i].addEventListener('click',delFnc);
    function delFnc(){
    del[i].parentNode.parentNode.remove();
};
}



