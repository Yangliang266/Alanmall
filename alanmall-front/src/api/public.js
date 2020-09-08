import axios from 'axios'

export default {
    fetchGet (url, params = {}) {
        return new Promise((resolve,reject) => {
          axios.get(url, params).then(res => {
            resolve(res.data)
          }).catch(error => {
            reject(error)
          })
        })
      },
      fetchPost (url, params = {}) {
        return new Promise((resolve, reject) => {
          axios.post(url, params).then(res => {
            resolve(res.data)
          }).catch(error => {
            reject(error)
          })
        })
      },
      fetchPut (url, params = {}) {
        return new Promise((resolve, reject) => {
          axios.put(url, params).then(res => {
            resolve(res.data)
          }).catch(error => {
            reject(error)
          })
        })
      },
      fetchDelete (url, params = {}) {
        return new Promise((resolve, reject) => {
          axios.delete(url, params).then(res => {
            resolve(res.data)
          }).catch(error => {
            reject(error)
          })
        })
      }
}