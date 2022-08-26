<template>
  <nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">
        JUST DO IT
      </router-link>

        <ul class="navbar-nav me-auto mb-2 mb-lg-0">

          <li class="nav-item">
            <router-link class="nav-link active" aria-current="page" :to="{ name : 'Login' }">
              Login
            </router-link>
          </li>

          <li class="nav-item">
            <router-link class="nav-link active" aria-current="page" :to="{ name : 'MemberList' }">
              MEMBER
            </router-link>
          </li>
        </ul>

    </div>
  </nav>

  <div class="container">
    <router-view/>
  </div>

</template>

<script>
  export default {
    name: 'app',
    data() {
      return {

      };
    },
    mounted(){
      //공통 이벤트 영역
      // $.initialize();
    },
    components: {
    }
  }
</script>

