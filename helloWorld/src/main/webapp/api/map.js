const fields = ['id', 'centerName', 'address', 'phoneNumber', 'sido', 'sigungu', 'map'];

function showCenterList(data) {

    //table요소가 있으면 삭제.
    if(document.getElementById('tbl')){
        document.getElementById('tbl').remove();
    };




    let table = document.createElement('table');
    table.setAttribute('border', '1');
    table.setAttribute('id', 'tbl');
    let thead = document.createElement('thead');
    let tbody = document.createElement('tbody');

    table.append(thead, tbody);
    //thead
    let tr = document.createElement('tr');
    fields.forEach(function (field) {
        let th = document.createElement('th');
        let text = document.createTextNode(field.toUpperCase());
        th.append(text);
        tr.append(th);
    });
    thead.append(tr);
    console.log(tr);
    //tbody
    data.forEach(function (item) {
        let tr = document.createElement('tr');
        fields.forEach(function (field) {
            //map=>link
            if(field == 'map'){
                let linkTag = document.createElement('a');
                linkTag.setAttribute('href',`daum.html?lat=${item.lat}&lng=${item.lng}&facility=${item.facilityName}`);
                linkTag.setAttribute('target','_blank');
                linkTag.innerText=item.centerName;

                let td= document.createElement('td');
                td.appendChild(linkTag);
                tr.append(td);
            }else{
             let td = document.createElement('td');
            let text = document.createTextNode(item[field]);
            td.append(text);
            tr.append(td);   
            }
            
        });
        tbody.append(tr);
    });
    document.getElementById('show').append(table);
}

//시도별로 센터정보 보여주기.
function showCenterListBySido(data){
    let centers =  data.data;
    
    let filteredCenter=[];
    centers.forEach(function(item,idx,value){
        //filteredCenter 값중에서 item.sido 같은 값이 없으면 추가
        if(filteredCenter.indexOf(item.sido) == -1){
            filteredCenter.push(item.sido);
        };   
    }); 
    console.log(filteredCenter);//a:값 ,b:인덱스값 c:배열그자체

    //버튼생성
    let show=document.getElementById('show');
    filteredCenter.forEach(function(centerName){
        let btn=document.createElement('button');
        btn.innerText = centerName;
        btn.addEventListener('click',showSidoList);
        show.appendChild(btn);
    });
    function showSidoList(){
        console.log(this.innerText);
        let searchCenterName= this.innerText;
       let filterArry = centers.filter(function(item){
          return item.sido == searchCenterName;
        });
        //fiterarry.length =>배열의 크기..
        let totalCnt=filterArry.length;
        let totalPage=Math.ceil(totalCnt / 10);


        let paging =document.getElementById('page');
        let children= paging.childNodes;
        let lnth=children.length;
        for(let i =0;i<lnth;i++){
            paging.removeChild(children[0]);
        }

        for(let i=1;i<=totalPage;i++){
            let aTag=document.createElement('a');
            aTag.innerText=i;
            aTag.setAttribute('href','#');
            aTag.addEventListener('click',pagingList);
            paging.appendChild(aTag);

        }
        console.log(filterArry);

        pagingList();
        function pagingList(){
           /* let allA = document.querySelectorAll('#page>a');
            for(let i=0;i<allA.length;i++){
                a.setAttribute('class','');
            }*/

            let page = this.innerText;
            if(this.nodeType==1){
                this.setAttribute('class','active');
            }
            if(page == null || page==''){
                page='1';
            }
            page = parseInt(page);
            pagingAry= filterArry.filter(function(item,idx){
                let startCnt=(page-1)*10;
                let endCnt=(page*10);
                return startCnt <= idx && idx <endCnt;
            });
            
        };
        showCenterList(filterArry);
    };
    //서울 특별시 클릭.
    let firstBtn=document.querySelector('#show>button:nth-child(1)');
    firstBtn.click();//클릭이벤트 호출

    //사용자가 입력한 값을 읽고,버튼=>이벤트 등록
    let searchBtn=document.querySelector('#searchBtn');
    console.log(searchBtn);
    searchBtn.addEventListener('click',addCallback);
    
    function addCallback(){
        let a=document.querySelector('input[name="searchCenter"]').value;
        let cnt=0;
        console.log(a,filteredCenter.indexOf(a));
        console.log(filteredCenter[filteredCenter.indexOf(a)]);
        console.log(filteredCenter);
        data.forEach(function(item,idx,value){
            
            fields.forEach(function (field) {
                console.log(item[field]);
            });
            
        });
        console.log(cnt);
    };
   
    
};


// Asynchoronous Javascript And Xml(ajax)
let url =
    'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=KXRnwcKQOb7%2BH%2B6c0kxVs1UtNhXP34EOszkvpa4MAVrY3JOL6rzuP8JKDxNS1cGavLTFKBwqTwxar%2BgpAFDzjw%3D%3D';

let xhtp = new XMLHttpRequest();
xhtp.onreadystatechange = function () {
    if (xhtp.readyState == 4 && xhtp.status == 200) {


        console.log('readystate: ' + xhtp.readyState);
        console.log('status:' + xhtp.status);
        let data = JSON.parse(xhtp.responseText);
        console.log(data);

        //showCenterList(data.data);//전체 센터
        showCenterListBySido(data);//시도별로 보기
    }
}
xhtp.open('get', url);
xhtp.send();