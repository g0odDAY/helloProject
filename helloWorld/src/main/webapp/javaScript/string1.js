var h3Tag=document.querySelector('h3');
var text= h3Tag.innerHTML;
var str=text.substring(2,10);
var elem=document.getElementById('show');
//elem.innerHTML = '<h3>Hello</h3>';
elem.innerText = str;
console.log(elem);
var a='9404071803111';
document.write(a.substring(6,7));

function getGender(jm){
    
    if(jm.substring(7,8)==1 || jm.substring(7,8)==3){
        return '남자';
    }else if(jm.substring(7,8)==2 || jm.substring(7,8)==4){
        return '여자';
    }else if(jm.substring(6,7)%2==1){
        return '남자';
    }else if(jm.substring(6,7)%2==0){
        return '여자';
    }
}
document.write(getGender('940407-1803111'));
document.write(getGender('9404071803111'));
document.write(getGender('9404072803111'));
document.write(getGender('940407 2803111'));

let str1='hello',str2='world';
console.log(str1.concat(' ',str2,'!!'));
let str3 = str1.concat(' ',str2,'!!');
let pos = str3.charAt(1);
console.log(pos);
let arry=str3.split(' ');
for(let str of arry){
    if('world!!'==str){
         console.log(str);
    }
   
}
let temp=' Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius facilis, quam itaque, reprehenderit, cum est cupiditate harum reiciendis excepturi aperiam expedita doloremque asperiores. Repellat, impedit dolor laudantium perspiciatis cumque molestiae?';
let tempArry=temp.split(' ');
console.log(tempArry.length);

let fruits='Apple Banana Cherry Melon';
let fruit=prompt('과일입력: ');
function getLoc(fruit){
    let arry1=fruits.split(' ');
    let cnt=1;
    console.log(arry1[3]);
   for(var i=0;i<arry1.length;i++){
        if(fruit==arry1[i]){
             cnt+=i;
             
        }
        if(cnt == 1){
            return '값이 없습니다.';
        }
        
    }
   return cnt;
}
console.log(getLoc(fruit));