const titles=['이름','학생번호','점수'];
const students=[
    {fullName:'류지희',stdNo:'1001',score:80},
    {fullName:'차주연',stdNo:'1002',score:50},
    {fullName:'전호민',stdNo:'1003',score:100}
];

let parent=document.getElementById('show');

let table=document.createElement('table');

table.setAttribute('border','1');
parent.appendChild(table);


//thead
let thead=document.createElement('thead');
let tr=document.createElement('tr');
thead.appendChild(tr);
titles.forEach(function(title) {
    let th=document.createElement('th');
    th.innerText=title;
    tr.appendChild(th);
});
let th=document.createElement('th');
th.innerText='삭제';
tr.appendChild(th);

table.appendChild(thead);


//tbody
let tbody=document.createElement('tbody');
students.forEach(function(title){
    let tr=document.createElement('tr');
    tr.onmouseover=function(e){
        e.target.style.backgroundColor='yellow';
        
    }
    tr.onmouseout=function(e){
        e.target.style.backgroundColor=null;
    }
    let td=document.createElement('td');
    td.innerText=title.fullName;
    tr.appendChild(td);

    td=document.createElement('td');
    td.innerText=title.stdNo;
    tr.appendChild(td);

    td=document.createElement('td');
    td.innerText=title.score;
    tr.appendChild(td);

    tbody.appendChild(tr);
    td=document.createElement('td');

let btn=document.createElement('button');
btn.onclick=function(e){
    console.log(e.target);
    e.target.parentNode.parentNode.remove();
};
let text=document.createTextNode('삭제');
btn.appendChild(text);
td.appendChild(btn);
tr.appendChild(td);
tbody.appendChild(tr);
});




table.appendChild(tbody);



console.log(table);