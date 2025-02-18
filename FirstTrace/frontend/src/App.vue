<template>
  <div class="app">
    <el-container>
      <el-header>
        <h1>留言本</h1>
      </el-header>
      <el-main>
        <MessageList />
      </el-main>
    </el-container>
  </div>
</template>

<script setup>
import MessageList from './components/MessageList.vue'
</script>

<style>
.app {
  min-height: 100vh;
  background-color: #f5f7fa;
}

.el-header {
  text-align: center;
  line-height: 60px;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12);
}
</style>