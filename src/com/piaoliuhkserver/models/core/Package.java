/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.piaoliuhkserver.models.core;

import com.piaoliuhkserver.models.dbengine.PackageDB;
import java.sql.SQLException;

/**
 *
 * @author zhiyo
 */
public class Package {
    public int PackageID;
    public String PackageSerialID;
        public int PackageOwnerID ;
        public String PackageOwnerMobile ;
        public String PackageExpressCompany ;
        public String PackageExpressTrackNumber ;
        public String PackageSnapshot;
        public float PackageWeight ;
        public float PackageFee ;
        public int PackageInTimeStamp ;
        public int PackageOutTimeStamp ;
        public int PackageStatus ;
        public String PackageRemarks ;
        public int PackageWorkerID ;
        public String PackageRelatedTransitBillSerialID ;

        
    
    public void searchPackagebyExpressTrackNumber() throws SQLException {
        Package Package_Temp = new Package();
        if (this.PackageExpressTrackNumber != null) {
            Package_Temp = PackageDB.searchPackagebyExpressTrackNumber(this.PackageExpressTrackNumber);
        }
        if (this.PackageID != 0 ) {
            CloneThis(Package_Temp);
            //this.isAuthorized = true;
        }
    }
     public void CloneThis(Package f_Package) {
         this.PackageID = f_Package.PackageID;
     }
}
