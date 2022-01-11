function addNumber(first,last){
    var sum=first+last;
    return sum;
}
var result1=addNumber(10,20);
var result2=addNumber(15,25);
console.log(`첫번째: ${result1},두번째: ${result2}`);
function sumBetweenNum(first,last){
    var i=first;
    var sum=0;
    for(first;first<=last;first++){
        sum+=first;
    }
    document.write(`<p>${i}부터 ${last}사이의 값의 합은 ${sum}입니다.</p>`)
}
sumBetweenNum(1,10);
sumBetweenNum(2,15);