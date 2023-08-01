
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import HotelReservationHotelManager from "./components/listers/HotelReservationHotelCards"
import HotelReservationHotelDetail from "./components/listers/HotelReservationHotelDetail"

import HotelManagementHotelManagerManager from "./components/listers/HotelManagementHotelManagerCards"
import HotelManagementHotelManagerDetail from "./components/listers/HotelManagementHotelManagerDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/hotelReservations/hotels',
                name: 'HotelReservationHotelManager',
                component: HotelReservationHotelManager
            },
            {
                path: '/hotelReservations/hotels/:id',
                name: 'HotelReservationHotelDetail',
                component: HotelReservationHotelDetail
            },

            {
                path: '/hotelManagements/hotelManagers',
                name: 'HotelManagementHotelManagerManager',
                component: HotelManagementHotelManagerManager
            },
            {
                path: '/hotelManagements/hotelManagers/:id',
                name: 'HotelManagementHotelManagerDetail',
                component: HotelManagementHotelManagerDetail
            },



    ]
})
