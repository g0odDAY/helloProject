function sumArry(arry){
    var sum=0;
    for(var i =0 ;i<arry.length;i++){
        sum+=arry[i];
    }
    return sum;
}
var result=sumArry([1,2,3,4,5]);
console.log(`결과값: ${result}`);
function getMax(first,last){
    if(first > last){
        return first;
    }else{
        return last;
    }
}
console.log(getMax(30,40));
function getMaxVal(arry){
    var maxVal=0;
    for(var i =0;i<arry.length;i++){
        if(maxVal<arry[i]){
            maxVal=arry[i];
        }
    }
    return maxVal;
}

function getMinVal(arry){
    var minVal=Number.MAX_SAFE_INTEGER;
    for(var i=0;i<arry.length;i++){
        if(minVal>arry[i]){
            minVal=arry[i];
        }
    }
    return minVal;
}
var numArry = [34,20,1,15,8,99,10,55];
console.log(`최대값: ${getMaxVal(numArry)}`);
console.log(`최소값: ${getMinVal(numArry)}`);