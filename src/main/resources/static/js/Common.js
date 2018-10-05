function myFunction(x) {
    if (x.matches) { // If media query matches
        document.getElementById('Noti_icon_status').style.display = "block";
		document.getElementById('Mobile_Visibility_noti').style.display = "none";
    } else {
        document.getElementById('Noti_icon_status').style.display = "none";
		document.getElementById('Mobile_Visibility_noti').style.display = "block";
    }
}
var x = window.matchMedia("(max-width: 991px)");

$(document).ready(function () {
            $("#sidebar").mCustomScrollbar({
                theme: "minimal"
            });

            $('#dismiss, .overlay').on('click', function () {
                $('#sidebar').removeClass('active');
                $('.overlay').removeClass('active');
            });

            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').addClass('active');
                $('.overlay').addClass('active');
                $('.collapse.in').toggleClass('in');
                $('a[aria-expanded=true]').attr('aria-expanded', 'false');
            });
        });

let clock = setInterval(() => {
        clearInterval(clock)
        clock = null
		myFunction(x); // Call listener function at run time
		x.addListener(myFunction); // Attach listener function on state changes// JavaScript Document
    }, 200);