package com.dinesh.jetpackcompose.media_player.presentation

//@HiltViewModel
//class MediaViewModel @Inject constructor(
//    private val mediaRepository: MediaRepository,
//) : ViewModel() {
//
//    private val _videos = MutableStateFlow<List<Msg>>(emptyList())
//    val videos: StateFlow<List<Msg>> = _videos
//
//    init {
//        fetchVideos()
//    }
//
//    private fun fetchVideos() {
//        viewModelScope.launch {
//            try {
//                val response = mediaRepository.getAllVideos()
//                _videos.value = response.msg
//                Log.i("Media: ", response.msg.toString())
//            } catch (e: Exception) {
//                // Handle error
//            }
//        }
//    }
//}