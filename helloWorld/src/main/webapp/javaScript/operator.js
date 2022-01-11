var numAry=[3,9,20,14,8,22];
var sum=0;
var iVal=window.prompt("갑을입력");
console.log(iVal);
for(var num of numAry){
    console.log(num);
    if(num % 2==0){
         sum+=num;
    }
     if(num ===parseInt(iVal)){
         break;
     } 
    
}
console.log('합계:'+sum);
var sum_2=0;
var sum_3=0;
var sum_23=0;
for(var i = 1;i<=20;i++){
    if(i%2==0){
        sum_2+=i;
    }
    if(i%3==0){
        sum_3+=i;
    }
    if(i%2==0 && i%3==0){
        sum_23+=i;
    }
}
console.log(`2의 배수 합계: ${sum_2}`);
console.log(`3의 배수 합계: ${sum_3}`);
console.log(`2와 3의 배수 합계: ${sum_23}`);