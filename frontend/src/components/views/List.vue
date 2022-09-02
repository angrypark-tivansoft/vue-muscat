<template>
    <div class="wrap">
        <li>
            <router-link :to="{name: 'home'}">
                Home
            </router-link>
        </li>
        <div>
          <table>
            <tr>
              <th>품목</th>
              <th>가격</th>
              <th>개수</th>
              <th>총가격</th>
            </tr>
            <tr v-for="item in itemInfoList" :key="item.cardNo">
              <td><span v-html="item.itemNm"></span></td>
              <td><span v-html="item.amt"></span></td>
              <td><span v-html="item.buyCnt"></span></td>
              <td><span v-html="item.totAmt"></span></td>
            </tr>
          </table>

          <table>
            <tr>
              <th>카드번호</th>
              <th>가격</th>
              <th>부가세</th>
            </tr>
            <tr>
              <td><span v-html="receiptInfo.cardNo"></span></td>
              <td><span v-html="receiptInfo.totAmt"></span></td>
              <td><span v-html="receiptInfo.vat"></span></td>
            </tr>
          </table>

          <p>
            <button @click="getListHttp">HttpConnection으로 가져오기</button>
            <button @click="getListRest">RestTemplate GET으로 가져오기</button>
            <button @click="postListRest">RestTemplate POST으로 가져오기</button>
            <button @click="postListWc">WebClient POST으로 가져오기</button>
          </p>


        </div>
    </div>
</template>

<script>
    import listApi from '@/api/list';

    export default {
        name: 'login',
        components : {

        },
        data() {
             return  {
               itemInfoList: [],
               receiptInfo :[]
             }
        },
        beforeCreate(){

        },
        created() {

        },
        mounted (){

        },
        methods: {

         getListHttp: function(){

              const data = {
              }

              listApi.getListHttp(data).then(response => {
                alert(JSON.stringify(response.data));
                this.itemInfoList = response.data.itemInfoList;
                this.receiptInfo = response.data.receiptInfo;
             });

          },

          getListRest: function(){

            const data = {
            }

            listApi.getListRest(data).then(response => {
              alert(JSON.stringify(response.data));
              this.itemInfoList = response.data.itemInfoList;
              this.receiptInfo = response.data.receiptInfo;
            });

          },

          postListRest: function(){

            const data = {
            }

            listApi.postListRest(data).then(response => {
              alert(JSON.stringify(response.data));
              this.itemInfoList = response.data.itemInfoList;
              this.receiptInfo = response.data.receiptInfo;
            });

          },

          postListWc: function(){

            const data = {
            }

            listApi.postListWc(data).then(response => {
              alert(JSON.stringify(response.data));
              this.itemInfoList = response.data.itemInfoList;
              this.receiptInfo = response.data.receiptInfo;
            });

          }



        }

    }

</script>

<style>
td, th {
  padding: 10px;
  border: 1px solid #ccc;
}
body {
  padding: 1rem;
}
</style>

