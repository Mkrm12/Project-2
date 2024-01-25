// Array to store users
const users = [
    'User 1', 'User 2', 'User 3', 'User 4', 'User 5',
    'User 6', 'User 7', 'User 8', 'User 9', 'User 10'
  ];
  
  // Array to store the order in which users will receive payments
  let paymentOrder = [];
  
  // Array to store payments made each month
  const payments = [];
  
  // Array to store users who received payment and need to make monthly payments
  const usersWithPayments = [];
  
  // Function to shuffle array randomly (Fisher-Yates algorithm)
  function shuffleArray(array) {
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [array[i], array[j]] = [array[j], array[i]];
    }
  }
  
  // Function to initialize the payment order array
  function initializePaymentOrder() {
    paymentOrder = Array.from({ length: users.length }, (_, index) => index + 1);
    shuffleArray(paymentOrder);
  }
  console.log("aaaaa", paymentOrder);
  // Function to simulate monthly payment process
  function makePayment() {
    if (paymentOrder.length === 0) {
      initializePaymentOrder();
    }
  
    const currentUser = paymentOrder.pop();
    const paymentAmount = 1000;
  
    payments.push({
      user: users[currentUser - 1],
      amount: paymentAmount
    });
  
    console.log(`${users[currentUser - 1]} received $${paymentAmount}. Remaining users: ${paymentOrder.length}`);
  
    usersWithPayments.push(users[currentUser - 1]);
  }
  
  // Function to simulate monthly payments by users who received payment
  function makeMonthlyPayment() {
    usersWithPayments.forEach((user, index) => {
      console.log(`${user} is making monthly payment $100 for month ${index + 1}`);
    });
  }
  
  // Simulate payments for 10 months
  for (let month = 1; month <= 10; month++) {
    console.log(`\nMonth ${month}:`);
    makePayment();
  }
  
  // Display total payments made
  console.log("\nTotal payments made:");
  payments.forEach((payment, index) => {
    console.log(`Month ${index + 1}: ${payment.user} received $${payment.amount}`);
  });
  
  // Display monthly payments made by users who received payments
  console.log("\nMonthly payments made by users who received payments:");
  makeMonthlyPayment();
  