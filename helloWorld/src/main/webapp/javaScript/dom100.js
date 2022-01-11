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
function makeHead(){
    const titles=['이름','연락처','주소','이메일'];
    let thead=document.createElement('thead');
    let tr=document.createElement('tr');
    //
    let th=document.createElement('th');
    let checkbox=document.createElement('input');
    checkbox.setAttribute('type','checkbox');
    checkbox.addEventListener('chanege',allCheckFnc());
    th.appendChild(checkbox);
    tr.appendChild(th);
    //
    titles.forEach(function(title){
        let text=document.createTextNode(title);
        let th=document.createElement('th');
        th.appendChild(text);
        tr.appendChild(th);
    });
    thead.appendChild(tr);
    return thead;
};
function allCheckFnc(){
console.log(this.checked);
let chks=document.querySelectorAll('tbody input[type="checkbox"]');
for (var i = 0; i < chks.length; i++) {
    chks[i].checkbox = this.checked;
}
};
function makeBody(){
    let tbody=document.createElement('tbody');
    
    data.forEach(function(data){
        console.log(data);
       tbody.appendChild(makeTr(data));
    });
    return tbody;
};
function makeTr(data){
    let tr=document.createElement('tr');
    //
    let td = document.createElement('td');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox');
    td.appendChild(checkbox);
    tr.appendChild(td);

for(let field in data){
    let td=document.createElement('td');
    let text=document.createTextNode(data[field]);
    console.log(text);
    td.appendChild(text);
    tr.appendChild(td);
    }
    return tr;
};

let table=document.createElement('table');
table.setAttribute('border','1');
table.appendChild(makeHead());
table.appendChild(makeBody());
document.getElementById('list').appendChild(table);
console.log(table);