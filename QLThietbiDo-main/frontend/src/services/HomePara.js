import axios from 'axios'
const HOME_PARA_URL ='http://localhost:8085/api/all'

class HomePara{
   async getParaHome(){
        return await axios.get(HOME_PARA_URL);
    }
}
export default new HomePara()