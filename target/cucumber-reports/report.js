$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BuyMacBookPro.feature");
formatter.feature({
  "line": 2,
  "name": "Buying a MacBook Pro on the website",
  "description": "\r\nAs an online customer\r\nI want to choose a MacBook with accessories on the website\r\nSo so that I can buy it online",
  "id": "buying-a-macbook-pro-on-the-website",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@buymacbookpro"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "A MacBook 15” with accessories can be ordered on the website",
  "description": "",
  "id": "buying-a-macbook-pro-on-the-website;a-macbook-15”-with-accessories-can-be-ordered-on-the-website",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@macfeatures"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I go to the website",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I choose a MacBook Pro with the following features and accessories",
  "rows": [
    {
      "cells": [
        "Option",
        "Specification"
      ],
      "line": 11
    },
    {
      "cells": [
        "Screen",
        "15’’"
      ],
      "line": 12
    },
    {
      "cells": [
        "Processor",
        "2.9 GHz"
      ],
      "line": 13
    },
    {
      "cells": [
        "Colour",
        "Silver"
      ],
      "line": 14
    },
    {
      "cells": [
        "Software",
        "Logic Pro X"
      ],
      "line": 15
    },
    {
      "cells": [
        "Display adapter",
        "USB-C to USB Adapter"
      ],
      "line": 16
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I can place an order for it.",
  "keyword": "Then "
});
formatter.match({
  "location": "BuyMacBookProStepDefs.iGoToTheWebsite()"
});
formatter.result({
  "duration": 6170787236,
  "status": "passed"
});
formatter.match({
  "location": "BuyMacBookProStepDefs.iChooseAMacBookProWithTheFollowingFeaturesAndAccessories(DataTable)"
});
formatter.result({
  "duration": 34164607548,
  "status": "passed"
});
formatter.match({
  "location": "BuyMacBookProStepDefs.iCanPlaceAnOrderForIt()"
});
formatter.result({
  "duration": 3021405905,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "The correct price and VAT are displayed for a MacBook 15” with accessories",
  "description": "",
  "id": "buying-a-macbook-pro-on-the-website;the-correct-price-and-vat-are-displayed-for-a-macbook-15”-with-accessories",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@verifyprices"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "when I choose the following items:",
  "rows": [
    {
      "cells": [
        "Option",
        "Price in £"
      ],
      "line": 22
    },
    {
      "cells": [
        "MacBook Pro",
        "2699.00"
      ],
      "line": 23
    },
    {
      "cells": [
        "Logic Pro X",
        "199.99"
      ],
      "line": 24
    },
    {
      "cells": [
        "Display adapter",
        "19.00"
      ],
      "line": 25
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "I proceed to the checkout",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "a total price of £2917.99 will be displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "£486.34 will be listed for VAT.",
  "keyword": "And "
});
formatter.match({
  "location": "BuyMacBookProStepDefs.whenIChooseTheFollowingItems(DataTable)"
});
formatter.result({
  "duration": 40671005107,
  "status": "passed"
});
formatter.match({
  "location": "BuyMacBookProStepDefs.iProceedToTheCheckout()"
});
formatter.result({
  "duration": 144158,
  "status": "passed"
});
formatter.match({
  "location": "BuyMacBookProStepDefs.a_total_price_of_291799_will_be_displayed()"
});
formatter.result({
  "duration": 2089176262,
  "status": "passed"
});
formatter.match({
  "location": "BuyMacBookProStepDefs.a_VATPRICE_will_be_listed_for_vat()"
});
formatter.result({
  "duration": 2956584965,
  "status": "passed"
});
});