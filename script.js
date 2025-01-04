document.addEventListener("DOMContentLoaded", function() {
    // Smooth scrolling for navigation links
    const navLinks = document.querySelectorAll('nav ul li a');
    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            document.querySelector(this.getAttribute('href')).scrollIntoView({
                behavior: 'smooth'
            });
        });
    });

    // Form validation
    const form = document.querySelector('form');
    form.addEventListener('submit', function(e) {
        const name = document.getElementById('name');
        const email = document.getElementById('email');
        const message = document.getElementById('message');

        if (name.value === '' || email.value === '' || message.value === '') {
            e.preventDefault();
            alert('Please fill in all fields.');
        } else if (!validateEmail(email.value)) {
            e.preventDefault();
            alert('Please enter a valid email address.');
        } else {
            alert('Thank you for your submission!');
        }
    });

    function validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    }
});
function toggleImages() 
{
   var extraImages = document.getElementById('extra-images');
   var button = document.getElementById('toggle-button');

   // Toggle visibility
   if(extraImages.style.display === 'none') 
   {
       extraImages.style.display = 'block';
       button.textContent = 'Show Less ';
       
   } 
   else
   {
    extraImages.style.display = 'none';
       button.textContent = 'Show More';
       
   }
}
document.querySelector('.dropdown-btn').addEventListener('click', function() {
    const navList = document.querySelector('#navbar');
    navList.classList.toggle('show');
  });
  // Close menu when clicked anywhere on the screen or scrolled
  document.addEventListener('click', function(event) {
    const checkBox = document.getElementById('check');
    // Check if the click is outside the nav or the checkbox, and only close if the menu is open
    if (!event.target.closest('nav') && !event.target.closest('.checkbtn') && checkBox.checked) {
        checkBox.checked = false; // Close the menu
    }
});

// Close menu when scrolling
window.addEventListener('scroll', function() {
    const checkBox = document.getElementById('check');
    if (checkBox.checked) {
        checkBox.checked = false; // Close the menu on scroll
    }
});
});
  
