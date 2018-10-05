$(function(){
  $(".noti_custom").on("click",function(){
    $.notify({
      title: '<strong>Alert</strong>',
      icon: 'glyphicon glyphicon-star',
      message: "Hi, I am Notification I am NotificationI am NotificationI am NotificationI am Notification"
    },{
      type: 'info',
      showProgressbar: true,
      animate: {
		    enter: 'animated fadeInDown',
        exit: 'animated fadeOutDown'
      },
      placement: {
        from: "top",
        align: "center"
      },
      offset: 20,
      spacing: 10,
      z_index: 1031,
	  delay: 3000,
	  timer: 1000,
    });
  });
});// JavaScript Documentnoti_custom