

<template>
    <v-app id="inspire">
        <div>
            <v-app-bar color="primary" app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                    </span>
                </v-toolbar-title>
                <span v-if="urlPath!=null" 
                    class="mdi mdi-home" 
                    key="" 
                    to="/" 
                    @click="goHome()"
                    style="margin-left:10px; font-size:20px; cursor:pointer;"
		        ></span> 
                <v-spacer></v-spacer>

                <b style="margin-left:10px">{{username}} 님</b>
                <v-btn
                    text
                    color="white"
                    style="font-size:10px"
                    @click="logout()"
                >
                    Logout
                </v-btn>
            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>
                    <v-list-item
                        class="px-2"
                        key="hotels"
                        to="/hotelReservations/hotels"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        호텔
                    </v-list-item>


                    <v-list-item
                        class="px-2"
                        key="hotelManagers"
                        to="/hotelManagements/hotelManagers"
                        @click="changeUrl()"
                        color="primary"
                        style="font-weight:700;"
                    >
                        호텔 관리자
                    </v-list-item>


                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container style="padding:0px;" v-if="urlPath" fluid>
                <router-view></router-view>
            </v-container>
            <v-container style="padding:0px;" v-else fluid>
                <div style="width:100%; margin:0px 0px 20px 0px; position: relative;">
                    <v-img style="width:100%; height:300px;"
                        src="https://oaidalleapiprodscus.blob.core.windows.net/private/org-IsZwoYj8yobpFySuytSuI26N/user-ha9EUDa76s1yoHT6JzgqOaFI/img-SZah8NRHOYY0uoLe0QTg0ejR.png?st=2023-08-01T00%3A04%3A18Z&se=2023-08-01T02%3A04%3A18Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-08-01T00%3A14%3A38Z&ske=2023-08-02T00%3A14%3A38Z&sks=b&skv=2021-08-06&sig=VsSWzhVZnUwHeyOD4idT8HuSbKoJV0ZfjMmYDlQX0EM%3D"
                    ></v-img>
                    <div class="App-main-text-overlap">호텔 예약 서비스</div>
                    <div class="App-sub-text-overlap">고객 여러분, 우리의 믿을 수 있는 서비스는 당신의 모든 필요를 충족시킬 것입니다. 지금 바로 연락하여 최상의 경험을 누리세요. 우리는 항상 여러분을 위해 최선을 다할 것입니다.</div>
                </div>
                <v-row>
                    <v-col cols="4" class="d-flex justify-center" v-for="(aggregate, index) in aggregate" :key="index">
                        <div 
                            class="flip-card"
                            @mouseover="flipCard(index)"
                            @mouseleave="unflipCard(index)"
                            :class="{ 'is-flipped': flipped[index] }"
                        >
                            <div class="flip-card-inner">
                                <div class="flip-card-front">
                                    <v-card
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <div style="text-align: left; padding:10px 15px 15px 15px; margin-top:-10px;">
                                            <h2>{{ aggregate.title }}</h2>
                                            <div>{{ aggregate.description }}</div>
                                        </div>
                                    </v-card>
                                </div>
                                <div class="flip-card-back">
                                    <v-card
                                        color="primary"
                                        class="mx-auto"
                                        style="width:300px; min-height: 310px; margin-bottom:20px; text-align: center; border-radius: 10px;"
                                        outlined
                                        :key="aggregate.key"
                                        :to="aggregate.route"
                                        @click="changeUrl()"
                                    >
                                        <v-list-item style="padding:15px; margin:0px;">
                                            <v-img style="width:100%; height:120px; border-radius: 10px;" :src="aggregate.ImageUrl"></v-img>
                                        </v-list-item>
                                        <h2 style="color:white;">{{ aggregate.title }} 관리</h2>
                                    </v-card>
                                </div>
                            </div>
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>

export default {
    name: "App",
    props:{
        keycloakVal: Object
    },
    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
        urlPath: null,
        flipped: [],
        ImageUrl: 'https://oaidalleapiprodscus.blob.core.windows.net/private/org-IsZwoYj8yobpFySuytSuI26N/user-ha9EUDa76s1yoHT6JzgqOaFI/img-SZah8NRHOYY0uoLe0QTg0ejR.png?st=2023-08-01T00%3A04%3A18Z&se=2023-08-01T02%3A04%3A18Z&sp=r&sv=2021-08-06&sr=b&rscd=inline&rsct=image/png&skoid=6aaadede-4fb3-4698-a8f6-684d7786b067&sktid=a48cca56-e6da-484e-a814-9c849652bcb3&skt=2023-08-01T00%3A14%3A38Z&ske=2023-08-02T00%3A14%3A38Z&sks=b&skv=2021-08-06&sig=VsSWzhVZnUwHeyOD4idT8HuSbKoJV0ZfjMmYDlQX0EM%3D',
        aggregate: [
            { 
                title: '호텔', 
                description: '호텔 정보를 관리하는 엔터티', 
                key: 'hotels', 
                route: '/hotelReservations/hotels',
                ImageUrl: '',
            },
            { 
                title: '호텔 관리자', 
                description: '호텔 등록 및 정보 관리를 담당하는 엔터티', 
                key: 'hotelManagers', 
                route: '/hotelManagements/hotelManagers',
                ImageUrl: '',
            },
            
        ],
        username: '',
    }),
    
    async created() {
      var path = document.location.href.split("#/")
      this.urlPath = path[1];

      var me = this
      me.username = me.$OAuth.idTokenParsed.preferred_username

      if(!me.username){
          location.reload()
      }
    },
    watch: {
        cards(newCards) {
            this.flipped = new Array(newCards.length).fill(false);
        },
    },

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        },
        changeUrl() {
            var path = document.location.href.split("#/")
            this.urlPath = path[1];
            this.flipped.fill(false);
        },
        goHome() {
            this.urlPath = null;
        },
        flipCard(index) {
            this.$set(this.flipped, index, true);
        },
        unflipCard(index) {
            this.$set(this.flipped, index, false);
        },
        logout(){
            //const keycloak = new Keycloak();

            //keycloak.logout;
            if(confirm("로그아웃 하시겠습니까?")){
                localStorage.clear()
                location.href = 'http://localhost:9090/realms/master/protocol/openid-connect/logout'
            }
        },
    }
};
</script>
<style>
</style>
