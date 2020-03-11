var userApi = Vue.resource('/api/v1/users/{/id}')

Vue.component('user-row',{
    props: ['user'],
    template: '<div>{{user.username}}</div>'
});

Vue.component('users-list',{
    props: ['users'],
    template: '<div><user-row v-for="user in users" :key="user.id" :user="user"/></user-row></div>',
    created: function () {
        userApi.get().then(result => result.json().then(data => data.forEach(user => this.users.push(user))
    )
    )
    }
});

var app = new Vue({
    el: '#app',
    template: '<users-list :users="users" />',
    data: {
        users: []
    }
});