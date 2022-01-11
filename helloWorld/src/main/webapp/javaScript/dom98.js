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

let table = document.createElement('table');
table.setAttribute('border', '1');
table.appendChild(makeHead());
table.appendChild(makeBody());
document.getElementById('list').appendChild(table);
console.log(table);

//thead
function makeHead() {
    const fields = ['이름', '전화번호', '주소', '이메일'];
    let thead = document.createElement('thead');
    let tr = document.createElement('tr');
    //체크박스
    let th = document.createElement('th');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox');
    checkbox.addEventListener('change', allCheckFnc);
    th.appendChild(checkbox);
    tr.appendChild(th);
    //필드
    fields.forEach(function (field) {
        let th = document.createElement('th');
        let text = document.createTextNode(field);
        th.appendChild(text);
        tr.appendChild(th);
    });
    thead.appendChild(tr);
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
//행생성
function makeTr(data) {
    let tr = document.createElement('tr');
    //체크박스
    let td=document.createElement('td');
    let checkbox = document.createElement('input');
    checkbox.setAttribute('type', 'checkbox');
    checkbox.addEventListener('change', allCheckFnc);
    td.appendChild(checkbox);
    tr.appendChild(td);
    for (let field in data) {
        let td = document.createElement('td');
        let text = document.createTextNode(data[field]);
        td.appendChild(text);
        tr.appendChild(td);
    }
    return tr;
}