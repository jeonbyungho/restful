/**
 * @e url에서 pathinfo 추출
 * */
function sub_pathname() {
   const index = location.pathname.lastIndexOf('/');
   const info = location.pathname.substring(index + 1);
   return parseInt(info);
}

/**
 * @e url의 식별자
 * */
const pathinfo = sub_pathname();

/**
 * @e url의 식별자 존재 여부 확인
 * @NaN true
 * @number false
 * */
const isURLpathinfo = isNaN(pathinfo);

console.log('🍌collection', location.href, pathinfo);