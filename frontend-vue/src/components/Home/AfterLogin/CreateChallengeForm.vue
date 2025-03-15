<template>
    <div 
      class="challenge-form bg-white/80 backdrop-blur-sm p-6 rounded-xl shadow-md border sticky top-24 transition-all duration-500"
      :class="[
        isFormHighlighted 
          ? 'border-blue-400 shadow-lg shadow-blue-100 transform scale-105 ring-4 ring-blue-200' 
          : 'border-green-100'
      ]"
    >
      <div class="flex items-center mb-6">
        <div class="w-12 h-12 bg-gradient-to-br from-blue-400 to-blue-500 rounded-xl flex items-center justify-center mr-4 shadow-md">
          <span class="text-xl">{{ isEditing ? '✏️' : '✨' }}</span>
        </div>
        <h2 class="font-bold text-2xl text-blue-700">{{ isEditing ? 'Edit Challenge' : 'Create Challenge' }}</h2>
      </div>
      
      <form @submit.prevent="submitForm" class="space-y-4">
        <div>
          <label for="challengeName" class="block text-sm font-medium text-gray-700 mb-1">Challenge Name</label>
          <input 
            id="challengeName"
            v-model="challengeForm.challengeName" 
            placeholder="e.g., Morning meditation by the lake" 
            class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent"
            required 
          />
        </div>
        
        <div v-if="isEditing">
          <label for="status" class="block text-sm font-medium text-gray-700 mb-1">Status</label>
          <select 
            id="status"
            v-model="challengeForm.status" 
            class="w-full px-4 py-2 rounded-lg border border-gray-300 focus:outline-none focus:ring-2 focus:ring-green-500 focus:border-transparent"
          >
            <option value="NOT_STARTED">Not Started</option>
            <option value="IN_PROGRESS">In Progress</option>
            <option value="COMPLETED">Completed</option>
            <option value="CANCELLED">Cancelled</option>
          </select>
        </div>
        
        <div class="flex justify-end space-x-3">
          <button 
            v-if="isEditing" 
            type="button" 
            @click="cancelEdit" 
            class="px-4 py-2 border border-gray-300 rounded-full text-gray-700 hover:bg-gray-100"
          >
            Cancel
          </button>
          <button 
            type="submit" 
            class="bg-gradient-to-r from-green-500 to-blue-500 text-white py-2 px-6 rounded-full shadow-md hover:shadow-lg transition-shadow flex items-center"
          >
            <span>{{ isEditing ? 'Update Challenge' : 'Create Challenge' }}</span>
            <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 ml-2" viewBox="0 0 20 20" fill="currentColor">
              <path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd" />
            </svg>
          </button>
        </div>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    name: 'CreateChallengeForm',
    props: {
      isEditing: {
        type: Boolean,
        default: false
      },
      currentChallenge: {
        type: Object,
        default: () => ({
          challengeName: '',
          status: 'NOT_STARTED'
        })
      },
      isFormHighlighted: {
        type: Boolean,
        default: false
      }
    },
    data() {
      return {
        challengeForm: {
          challengeName: '',
          status: 'NOT_STARTED'
        }
      }
    },
    watch: {
      currentChallenge: {
        handler(newVal) {
          this.challengeForm = { ...newVal };
        },
        immediate: true,
        deep: true
      }
    },
    methods: {
      submitForm() {
        this.$emit('submit-form', { ...this.challengeForm });
      },
      cancelEdit() {
        this.$emit('cancel-edit');
      },
      focusInput() {
        this.$nextTick(() => {
          setTimeout(() => {
            const inputElement = document.getElementById('challengeName');
            if (inputElement) {
              inputElement.focus();
            }
          }, 300);
        });
      }
    }
  }
  </script>
  
  <style scoped>
  @keyframes highlight-pulse {
    0% {
      box-shadow: 0 0 0 0 rgba(96, 165, 250, 0.4);
    }
    70% {
      box-shadow: 0 0 0 10px rgba(96, 165, 250, 0);
    }
    100% {
      box-shadow: 0 0 0 0 rgba(96, 165, 250, 0);
    }
  }
  
  .challenge-form {
    transition: all 0.3s ease-in-out;
  }
  
  .challenge-form.transform {
    animation: highlight-pulse 2s 1;
  }
  
  button {
    transition: all 0.3s cubic-bezier(0.175, 0.885, 0.32, 1.275);
  }
  
  button:hover {
    transform: translateY(-2px);
    box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
  }
  
  button:active {
    transform: translateY(0) scale(0.98);
  }
  
  input:focus {
    box-shadow: 0 0 0 3px rgba(16, 185, 129, 0.2);
  }
  
  .rounded-lg {
    transition: all 0.2s ease;
  }
  
  .rounded-lg:hover {
    transform: translateY(-2px);
  }
  </style>