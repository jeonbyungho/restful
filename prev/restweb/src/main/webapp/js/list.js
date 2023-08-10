const origin = location.origin;
const pathname = location.pathname;
const index = pathname.lastIndexOf('/');
const sub = pathname.substring(index + 1);
const sub_int = parseInt(sub);

const doc_list = document.getElementById('list');
const doc_prev = document.getElementById('prev');
const doc_next = document.getElementById('next');

window.onload = () => {

   const url = origin + '/people/list/' + sub;
   console.log('📢GET Request', url);

   fetch(url)
   // 📜 json
   .then(resp => {
      if (!resp.ok) {
         throw new Error('🤮 에러 응답을 받았습니다.');
      }
      return resp.json();
   })
   // 🔨 li 태그 생성
   .then(json => {
      console.log(json);
      if(json.length < 1){
         alert('🤧더 이상 조회되는 목록이 없습니다.');
         window.location.href = origin + '/peoples/' + (sub_int - 1);
      }
      for(let i = 0; i < json.length; i++){
         const people = json[i];
         console.log(i, people);
         let new_li = document.createElement('li');
         let new_a = document.createElement('a');
             new_a.setAttribute('href', '/people/' + people['id']);
             new_a.innerHTML = people['name'];
         
         doc_list.appendChild(new_li);
         new_li.appendChild(new_a);
      }
   })
   // 😷 에러 처리
   .catch( (e) => {
      console.error(e.error);
   })

   // 이전 버튼 숨김
   if (parseInt(sub) <= 1){
      doc_prev.style.display = 'none';
   }
}

document.getElementById('back').onclick = (e)=> { window.history.back(); false;}

document.getElementById('prev').onclick = (e)=> { window.location.href = origin + '/peoples/' + (sub_int - 1); false;}
document.getElementById('next').onclick = (e)=> { window.location.href = origin + '/peoples/' + (sub_int + 1); false;}