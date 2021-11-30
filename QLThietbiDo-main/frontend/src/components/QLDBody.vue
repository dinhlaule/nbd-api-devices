<template>
    <div class="info" >
     
         <button class="btn btn-primary" v-on:click="clickAdd">{{msg_Btn}}</button>
        <div class="show">
            <label style="padding-right:5px">Show</label>
            <input type="number" id="inputNumber" value="10"/>
            <label>entries</label>
        </div>
        <div class="tableInfo">
           <table class="table-Info">
             <thead style="height:50px">
                 <th class="tieude"><input type="checkbox"/></th>
                 <th class="tieude">#</th>
                 <th class="tieude">Thao tác</th>
                 <th class="tieude"><input type="text" placeholder="Search Tên thiết bị"/></th>
                 <th class="tieude"><input type="text" placeholder="Search Mã thiết bị"/></th>
                 <th class="tieude"><input type="text" placeholder="Search yếu tố đo"/></th>
                 <th class="tieude"><input type="text" placeholder="Search Hãng sản xuất"/></th>
                 <th class="tieude"><input type="text" placeholder="Model"/></th>
                 <th class="tieude"><input type="text" placeholder="Search Trạng thái"/></th>
             </thead>
            <tbody>
                <tr v-for="(homepara,index) in homeparas" v-bind:key="index">
                    <td class="tieude"><input type="checkbox"></td>    
                    <td class="tieude">{{index + 1}}</td>
                    <td class="tieude"></td>
                    <td class="tieude">{{homepara.ins_name}}</td>
                    <td class="tieude">{{homepara.ins_id}}</td>
                    <td class="tieude"> {{homepara.parameter_type_name}}</td>
                    <td class="tieude">{{homepara.manufact}}</td>
                    <td class="tieude">{{homepara.ins_model}}</td>
                    <td class="tieude">{{homepara.status}}</td>
                </tr>
            </tbody>
           </table>
           
        </div>
        <QLDAdd v-if="isSelectButton"/>
    </div>
</template>
<script>
  import HomePara from "../services/HomePara"
  import QLDAdd from "../components/QLDAdd.vue"
  
export default{
   name: 'qld-body',
   components :{
    QLDAdd
   },
   data(){
       return{
           msg_Btn:'+Thêm',
           homeparas: [],
           isSelectButton: false
       }
   },
   methods:{
       clickAdd(){
        this.isSelectButton = true;
       },
       getParaHome(){
          HomePara.getParaHome().then((Response) =>{
              this.homeparas = Response.data;
          })
       }
   },
   created(){
       this.getParaHome();
   }
}
</script>
<style>
.info{
  margin-top:50px;
  display: relative;
}
  .btn-primary {
      background-color: #3385ff;
      width: 100px;
      height: 40px;
      font-weight: bold;
      margin-top: 50px;
      margin-left: 60px ;
      position: relative;
      top: auto;
      
  }
  .show{
   
      position: absolute;
      padding-top: 20px;
      margin-left: 60px ;
      position: relative;
      top:auto;
     
  }

  #inputNumber {
     width: 50px;
    
  }
    .tableInfo {
        margin-top: 30px;
        position: relative;
        top: auto;
    }

    .pagination {
        margin-top: 10px;
        float: right;
    }
    .table-Info {
        border: 1 px solid black;
       border-collapse: collapse;
       width: 100%;
       text-align: center;
       
    }
    th,td {
      border: 1 px solid black;
    }
    .tieude{
        border: 1px solid black;
        min-width: 40px;
    }
</style>
