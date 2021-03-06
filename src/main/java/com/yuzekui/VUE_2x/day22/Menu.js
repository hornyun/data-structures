/*
//Menu.vue  =》导航组件：
<template>
    <div>
        <template v-for="list in this.menuList" >
            // <!--组件在封装时需要传index ，index值为你的当前页面的名称eg（:index='菜单管理'    ！！！！！这里为关键点）  -->
            <el-submenu index="1" v-if="list.children.length>0" :key="list.resourceId" :index="list.resourceName"  >
            <template slot="title"  style="padding-left:10px" >
                <i class="el-icon-menu"></i>
                <span slot="title">{{ list.resourceName}}</span>
            </template>
            <Menu :menuList="list.children"></Menu>
    </el-submenu>
    <el-menu-item v-else :index="list.resourceName"  :key="list.resourceId" style="padding-left: 50px;" @click="changeRoute(list.resourceName)" >
    <span>{{list.resourceName}}</span>
</el-menu-item>
</template>
</div>
</template>*/
