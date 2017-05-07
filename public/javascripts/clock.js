/**
 * Created by dido on 11/3/14.
 */
$(document).ready(function () {
// Create two variable with the names of the months and days in an array
//                var monthNames = [ "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" ];
//                var dayNames= ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]

// Create a newDate() object
    var newDate = new Date();
// Extract the current date from Date object
    newDate.setDate(newDate.getDate());
// Output the day, date, month and year
    //  $('#clock-date').html(dayNames[newDate.getDay()] + " " + newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' + newDate.getFullYear());

    setInterval(function () {
        // Create a newDate() object and extract the seconds of the current time on the visitor's
        var hours = new Date().getHours();
        var minutes = new Date().getMinutes();
        var seconds = new Date().getSeconds();
        $("#clock-hours").html(( hours < 10 ? "0" : "" ) + hours);
        $("#clock-min").html(( minutes < 10 ? "0" : "" ) + minutes);
        $("#clock-sec").html(( seconds < 10 ? "0" : "" ) + seconds);
    }, 1000);


});
