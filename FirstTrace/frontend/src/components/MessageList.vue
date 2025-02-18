<template>
  <div class="message-container">
    <el-card class="message-form">
      <el-form :model="newMessage" label-width="80px">
        <el-form-item label="作者">
          <el-input v-model="newMessage.author"></el-input>
        </el-form-item>
        <el-form-item label="内容">
          <el-input type="textarea" v-model="newMessage.content"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitMessage">发布留言</el-button>
        </el-form-item>
      </el-form>
    </el-card>

    <el-card v-for="message in messages" :key="message.id" class="message-card">
      <template #header>
        <div class="card-header">
          <span>{{ message.author }}</span>
          <span class="time">{{ formatDate(message.createTime) }}</span>
        </div>
      </template>
      <div class="message-content">
        {{ message.content }}
      </div>
      <div class="message-actions">
        <el-button type="primary" size="small" @click="editMessage(message)">编辑</el-button>
        <el-button type="danger" size="small" @click="deleteMessage(message.id)">删除</el-button>
      </div>
    </el-card>

    <el-dialog v-model="dialogVisible" title="编辑留言">
      <el-form :model="editingMessage" label-width="80px">
        <el-form-item label="作者">
          <el-input v-model="editingMessage.author"></el-input>
        </el-form-item>
        <el-form-item label="内容">
          <el-input type="textarea" v-model="editingMessage.content"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="dialogVisible = false">取消</el-button>
          <el-button type="primary" @click="updateMessage">确定</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { ElMessage } from 'element-plus'

const messages = ref([])
const newMessage = ref({
  author: '',
  content: ''
})
const dialogVisible = ref(false)
const editingMessage = ref({})

const fetchMessages = async () => {
  try {
    const response = await axios.get('/api/messages')
    messages.value = response.data
  } catch (error) {
    ElMessage.error('获取留言失败')
  }
}

const submitMessage = async () => {
  try {
    await axios.post('/api/messages', newMessage.value)
    ElMessage.success('发布成功')
    newMessage.value = { author: '', content: '' }
    fetchMessages()
  } catch (error) {
    ElMessage.error('发布失败')
  }
}

const deleteMessage = async (id) => {
  try {
    await axios.delete(`/api/messages/${id}`)
    ElMessage.success('删除成功')
    fetchMessages()
  } catch (error) {
    ElMessage.error('删除失败')
  }
}

const editMessage = (message) => {
  editingMessage.value = { ...message }
  dialogVisible.value = true
}

const updateMessage = async () => {
  try {
    await axios.put(`/api/messages/${editingMessage.value.id}`, editingMessage.value)
    ElMessage.success('更新成功')
    dialogVisible.value = false
    fetchMessages()
  } catch (error) {
    ElMessage.error('更新失败')
  }
}

const formatDate = (dateStr) => {
  if (!dateStr) return ''
  const date = new Date(dateStr)
  return date.toLocaleString()
}

onMounted(() => {
  fetchMessages()
})
</script>

<style scoped>
.message-container {
  max-width: 800px;
  margin: 20px auto;
}

.message-form {
  margin-bottom: 20px;
}

.message-card {
  margin-bottom: 15px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.time {
  font-size: 0.9em;
  color: #999;
}

.message-content {
  margin: 10px 0;
}

.message-actions {
  display: flex;
  gap: 10px;
  justify-content: flex-end;
}
</style>