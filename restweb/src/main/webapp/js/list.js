const origin = location.origin;
const pathname = location.pathname;

const doc_list = document.getElementById('list');

window.onload = () => {
   const index = pathname.lastIndexOf('/');
   const sub = pathname.substring(index + 1);

   const url = origin + '/people/list/' + sub;
   console.log('📢GET Request', url);

   fetch(url)
   .then(resp => {
      if (!resp.ok) {
         throw new Error('🤮 에러 응답을 받았습니다.');
      }
      return resp.json();
   })
   .then(json => {
      console.log(json);
      for(let i = 0; i < json.length; i++){
         const people = json[i];
         console.log(i, people);
         let new_a = document.createElement('a');
             new_a.setAttribute('href', '/people/' + people['id']);
             new_a.innerHTML = people['name'];
         doc_list.appendChild(new_a);
      }
   })
   .catch( (e) => {
      console.error(e.error);
   })
}

document.getElementById('back').onclick = (e)=> { window.history.back(); false;}