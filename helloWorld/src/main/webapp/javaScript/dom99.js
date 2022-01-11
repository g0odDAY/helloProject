const data = [{
        name: '류지희',
        phone: '010-3549-5468',
        addr: '대구 중구 100번지',
        email: 'dsf@gmail.com'
    },
    {
        name: '황규복',
        phone: '010-5646-5888',
        addr: '대구 중구 101번지',
        email: 'rbqhr@gmail.com'
    },
    {
        name: '이운우',
        phone: '010-4699-8498',
        addr: '대구 중구 102번지',
        email: 'unty@gmail.com'
    },
    {
        name: '전호민',
        phone: '010-3549-5468',
        addr: '대구 중구 100번지',
        email: 'dsf@gmail.com'
    }
];

function makeHead() {
    const fields = ['이름', '연락처', '주소', '이메일'];
    let thead = document.createElement('thead');
    let tr = document.createElement('tr');
    //체크박스
    let th = document.createElement('th');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox');
    checkbox.addEventListener('change', allCheckFnc());
    th.appendChild(checkbox);
    tr.appendChild(th);
    //필드영역
    fields.forEach(function (field) {
        let th = document.createElement('th');
        let text = document.createTextNode(field);
        th.appendChild(text);
        tr.appendChild(th);
    });

    table.appendChild(tr);
    return thead;
}

function allCheckFnc() {
    console.log(this.checked);
    let chks = document.querySelectorAll('tbody input[type="checkbox"]');
    for (var i = 0; i < chks.length; i++) {
        chks[i].checkbox = this.checked;
    }
}


//tbody
function makeBody() {
    let tbody = document.createElement('tbody');
    data.forEach(function (data) {

        tbody.appendChild(makeTr(data));
    });
    return tbody;
}
//tr생성
function makeTr(data) {
    let tr = document.createElement('tr');
    //체크박스
    let td = document.createElement('td');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox');
    td.appendChild(checkbox);
    tr.appendChild(td);
    //데이터영역
    for (let field in data) {
        let td = document.createElement('td');
        let text = document.createTextNode(data[field]);
        console.log(text);
        td.appendChild(text);
        tr.appendChild(td);
    }
    return tr;
}

let addBtn=document.querySelector('#btn>button');
addBtn.addEventListener('click',addCallback);
function addCallback(){
    let name=document.querySelector('input[name="name"]').value;
    let phone=document.querySelector('input[name="phone"]').value;
    let addr=document.querySelector('input[name="addr"]').value;
    let email=document.querySelector('input[name="email"]').value;
    if(name==""||phone==""||addr==""||email==""){
        window.alert('필수 값을 입력하세요.');
        return;
    }
    let obj={
        name:name,
        phone:phone,
        addr:addr,
        email:email
    }
    let tr=makeTr(obj);
    document.querySelector('#list>table>tbody').appendChild(tr);
}
let delBtn=document.querySelector('#btn>button:nth-child(2)');

delBtn.addEventListener('click',delCallback);
function delCallback(){
    let chks=document.querySelectorAll('tbody input[type="checkbox"]');
    console.log(chks);
    for(let i=0;i<chks.length;i++){
        
        if(chks[i].checked==true){
           // console.log(chks[i].parentNode);
            chks[i].parentNode.parentNode.remove();
        }
    }
}
let names=document.querySelectorAll('table tbody tr td:nth-child(2)');
console.log(names);
for(let i = 0;i<names.length;i++){
    names[i].addEventListener('click',showInfo);
}
function showInfo(){
    let parent=names[0].parentNode;
    console.log(parent.childNodes[2].innerText);
    document.querySelector('input[name="phone"]').value
    =parent.childNodes[2].innerText;
    };
//---------------------------------------------

let table = document.createElement('table');
table.setAttribute('border', '1');
table.appendChild(makeHead());
table.appendChild(makeBody());
document.getElementById('list').appendChild(table);

console.log(table);
