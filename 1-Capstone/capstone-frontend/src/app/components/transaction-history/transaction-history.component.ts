import { Component, OnInit } from '@angular/core';
import { Transaction } from 'src/app/models/transaction';
import { Customer } from 'src/app/models/customer';
import { TransactionService } from 'src/app/services/transaction.service';
import { ActivatedRoute } from '@angular/router';
import { RoutingService } from 'src/app/services/routing.service';
import { CustomerService } from 'src/app/services/customer.service';
@Component({
  selector: 'app-transaction-history',
  templateUrl: './transaction-history.component.html',
  styleUrls: ['./transaction-history.component.css']
})
export class TransactionHistoryComponent implements OnInit {
  trxArray: Transaction[] = [];
  currentloggedincustomer: any = ''
  trxId = ''
  customer!: Customer;
  isLoaded = false;
  page = 1;
  pageSize = 5;
  collectionSize!:number;
  currentRate = 3;

  getAllTransactions() {
    this.currentloggedincustomer = this.routingService.getLoggedInCustomer();
    this.customerService.fetchcustomerByName(this.currentloggedincustomer).subscribe(res => {
      this.customer = res;


      this.transactionService.fetchAllTransactionsByCustomerId(this.customer.customerId).subscribe((res) => {
        this.trxArray = res;
        this.collectionSize=this.trxArray.length;
        this.isLoaded = true;
      });

    });
  }

  constructor(private transactionService: TransactionService, private route: ActivatedRoute, private routingService: RoutingService, private customerService: CustomerService) { }
  ngOnInit(): void {
    this.getAllTransactions();
  }

}

